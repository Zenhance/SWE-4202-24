import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Relay — An Outbound Message Hub.
 *
 * This is the specification for the lab. Do NOT modify this file.
 *
 * It is also your guide to the exact method signatures: the way each method is
 * called here (its arguments, and the type each return value is used as) tells
 * you what to declare. The problem statement tells you how the classes relate;
 * this file tells you their shapes. Read both together.
 *
 * Your classes live in the default package, under src/main/java/.
 */
class RelayTest {

    // --- The pricing and formatting rules the system must obey -------------
    private static final int    SMS_SEGMENT_SIZE   = 160;   // chars per SMS segment
    private static final double SMS_PER_SEGMENT    = 0.50;  // charge per segment
    private static final double PUSH_FLAT          = 0.10;  // flat push charge
    private static final int    PUSH_PREVIEW_CHARS = 40;    // push trims to this many chars
    private static final double PRIORITY_SURCHARGE = 0.30;  // added on top of the e-mail's cost
    private static final double EPS = 1e-9;

    // --- Small helpers for building fixtures (all digit-free on purpose, so
    //     that an SMS segment-count digit cannot collide with other text) ---
    private Recipient someone() {
        return new Recipient("Ada Lovelace", "ada@analytical.engine");
    }

    private String textOfLength(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append('x');
        return sb.toString();
    }

    private int expectedSegments(int textLength) {
        return Math.max(1, (int) Math.ceil(textLength / (double) SMS_SEGMENT_SIZE));
    }

    // =====================================================================
    @Nested
    @DisplayName("Each channel speaks in its own voice")
    class ChannelVoice {

        @Test
        @DisplayName("the same notice delivers differently on each channel")
        void channelsDifferForSameInput() {
            Recipient r = someone();
            String body = "your code is ready";

            String email = new EmailMessage(r, body).deliver();
            String sms   = new SmsMessage(r, body).deliver();
            String push  = new PushMessage(r, body).deliver();

            assertNotEquals(email, sms,  "e-mail and SMS must not deliver identically");
            assertNotEquals(sms,   push, "SMS and push must not deliver identically");
            assertNotEquals(email, push, "e-mail and push must not deliver identically");
        }

        @Test
        @DisplayName("the e-mail line names the recipient")
        void emailNamesRecipient() {
            Recipient r = someone();
            String line = new EmailMessage(r, "hello").deliver();
            assertTrue(line.contains(r.getName()),    "e-mail should mention the recipient's name");
            assertTrue(line.contains(r.getAddress()), "e-mail should mention the recipient's address");
        }

        @Test
        @DisplayName("the SMS line states how many segments it became")
        void smsStatesSegmentCount() {
            Recipient r = someone();
            int length = 2 * SMS_SEGMENT_SIZE + 5;     // forces 3 segments
            String line = new SmsMessage(r, textOfLength(length)).deliver();
            assertTrue(line.contains(Integer.toString(expectedSegments(length))),
                    "SMS delivery should show its segment count (" + expectedSegments(length) + ")");
        }

        @Test
        @DisplayName("the push is trimmed to a short preview")
        void pushIsTrimmed() {
            Recipient r = someone();
            String body = textOfLength(120);
            String line = new PushMessage(r, body).deliver();

            assertTrue(line.contains(body.substring(0, PUSH_PREVIEW_CHARS)),
                    "push should keep the first " + PUSH_PREVIEW_CHARS + " characters");
            assertFalse(line.contains(body.substring(0, PUSH_PREVIEW_CHARS + 1)),
                    "push should cut the text off at " + PUSH_PREVIEW_CHARS + " characters");

            String shortBody = "tiny note";
            assertTrue(new PushMessage(r, shortBody).deliver().contains(shortBody),
                    "a short push keeps its whole text");
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Cost follows behaviour, not a stored number")
    class CostRules {

        @Test
        @DisplayName("e-mail is free")
        void emailIsFree() {
            assertEquals(0.0, new EmailMessage(someone(), "anything").cost(), EPS);
        }

        @Test
        @DisplayName("a longer SMS costs more, because it splits into more segments")
        void smsScalesWithSegments() {
            Recipient r = someone();
            SmsMessage shortSms = new SmsMessage(r, textOfLength(50));                 // 1 segment
            SmsMessage longSms  = new SmsMessage(r, textOfLength(SMS_SEGMENT_SIZE + 1)); // 2 segments

            assertEquals(expectedSegments(50) * SMS_PER_SEGMENT, shortSms.cost(), EPS);
            assertEquals(expectedSegments(SMS_SEGMENT_SIZE + 1) * SMS_PER_SEGMENT, longSms.cost(), EPS);
            assertTrue(longSms.cost() > shortSms.cost(), "the longer text must cost more");
        }

        @Test
        @DisplayName("push is the flat amount")
        void pushIsFlat() {
            assertEquals(PUSH_FLAT, new PushMessage(someone(), textOfLength(500)).cost(), EPS);
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("The priority e-mail is built ON the e-mail")
    class PriorityBuiltOnEmail {

        @Test
        @DisplayName("priority delivery contains the plain e-mail's line, verbatim, with a flag in front")
        void priorityReusesEmailDelivery() {
            Recipient r = someone();
            String body = "wheels up in ten minutes";

            String plainEmailLine = new EmailMessage(r, body).deliver();
            String priorityLine   = new PriorityEmailMessage(r, body).deliver();

            assertTrue(priorityLine.contains(plainEmailLine),
                    "the priority e-mail must reuse the e-mail's delivered text verbatim, not re-derive it");
            assertFalse(priorityLine.equals(plainEmailLine),
                    "the priority e-mail must add something of its own in front");
            assertTrue(priorityLine.indexOf(plainEmailLine) > 0,
                    "the priority flag should sit ahead of the e-mail line");
        }

        @Test
        @DisplayName("priority cost is the e-mail's cost plus the surcharge")
        void priorityReusesEmailCost() {
            Recipient r = someone();
            String body = "wheels up in ten minutes";

            double emailCost    = new EmailMessage(r, body).cost();
            double priorityCost = new PriorityEmailMessage(r, body).cost();

            assertEquals(emailCost + PRIORITY_SURCHARGE, priorityCost, EPS);
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("The audit description differs per channel")
    class Describe {

        @Test
        @DisplayName("each kind describes itself in a recognisably different way")
        void describesPerChannel() {
            Recipient r = someone();
            assertTrue(new EmailMessage(r, "x").describe().contains("EMAIL"));
            assertTrue(new SmsMessage(r, "x").describe().contains("SMS"));
            assertTrue(new PushMessage(r, "x").describe().contains("PUSH"));
            assertTrue(new PriorityEmailMessage(r, "x").describe().contains("PRIORITY"));
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("One outbox holds many kinds, side by side")
    class MixedOutbox {

        @Test
        @DisplayName("a mixed batch reports its size and a total equal to the parts")
        void totalEqualsSumOfParts() {
            Recipient r = someone();
            Message email = new EmailMessage(r, "confirm");
            Message sms   = new SmsMessage(r, textOfLength(SMS_SEGMENT_SIZE + 1));
            Message push  = new PushMessage(r, "ping");
            Message prio  = new PriorityEmailMessage(r, "urgent");

            // The four different kinds must fit together in one container.
            Message[] batch = { email, sms, push, prio };

            Outbox outbox = new Outbox();
            for (Message m : batch) {
                outbox.enqueue(m);
            }

            assertEquals(4, outbox.size(), "four notices were queued");
            assertEquals(email.cost() + sms.cost() + push.cost() + prio.cost(),
                    outbox.totalCost(), EPS,
                    "the batch total must equal each notice's own cost, added up");
        }

        @Test
        @DisplayName("flushing transmits everything in one sweep, in queue order")
        void flushSendsAllInOrder() {
            Recipient r = someone();
            Message email = new EmailMessage(r, "first");
            Message sms   = new SmsMessage(r, "second");
            Message push  = new PushMessage(r, "third");

            Outbox outbox = new Outbox();
            outbox.enqueue(email);
            outbox.enqueue(sms);
            outbox.enqueue(push);

            String log = outbox.flush();

            assertTrue(log.contains(email.deliver()), "log should contain the e-mail's line");
            assertTrue(log.contains(sms.deliver()),   "log should contain the SMS line");
            assertTrue(log.contains(push.deliver()),  "log should contain the push line");
            assertTrue(log.indexOf(email.deliver()) < log.indexOf(sms.deliver()), "e-mail before SMS");
            assertTrue(log.indexOf(sms.deliver())   < log.indexOf(push.deliver()), "SMS before push");
        }

        @Test
        @DisplayName("one variable can stand in for any channel")
        void oneSlotManyForms() {
            Recipient r = someone();
            Outbox outbox = new Outbox();

            Message slot = new EmailMessage(r, "a");
            outbox.enqueue(slot);
            slot = new SmsMessage(r, "b");
            outbox.enqueue(slot);
            slot = new PushMessage(r, "c");
            outbox.enqueue(slot);
            slot = new PriorityEmailMessage(r, "d");
            outbox.enqueue(slot);

            assertEquals(4, outbox.size(), "the same variable, reassigned to each kind, queues all four");
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Queue once, or queue many (one name, two input shapes)")
    class EnqueueOverload {

        @Test
        @DisplayName("a repeat count queues that many copies and multiplies the cost")
        void repeatCountMultiplies() {
            Recipient r = someone();
            Message sms = new SmsMessage(r, textOfLength(SMS_SEGMENT_SIZE + 1)); // 2 segments

            Outbox outbox = new Outbox();
            outbox.enqueue(sms, 3);

            assertEquals(3, outbox.size(), "a repeat of three should leave three waiting");
            assertEquals(sms.cost() * 3, outbox.totalCost(), EPS, "three copies cost three times as much");
        }

        @Test
        @DisplayName("the plain form queues exactly one")
        void plainFormQueuesOne() {
            Recipient r = someone();
            Message push = new PushMessage(r, "once");

            Outbox outbox = new Outbox();
            outbox.enqueue(push);

            assertEquals(1, outbox.size(), "the single-argument form queues exactly one");
            assertEquals(push.cost(), outbox.totalCost(), EPS);
        }
    }
}
