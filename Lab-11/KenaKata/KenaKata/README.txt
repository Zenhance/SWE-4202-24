Team: [Write your team name here]

Seller - class: represents one marketplace seller.
Chargeable - interface: common pricing contract for products and add-ons.
CatalogItem - abstract class: stores shared catalogue identity, price, seller, and stock behaviour.
StockedGood - class: physical, weighable, insurable, returnable catalogue item.
DigitalGood - class: non-shipping digital catalogue item.
FreshGood - class: weighable cold-chain, insurable, returnable catalogue item.
GiftWrap - class: fixed-price add-on.
ExpressHandling - class: fixed-price add-on.
WarrantyPlan - class: percentage-price add-on tied to a catalogue item.
Weighable - interface: optional line capability used for delivery weight.
ColdChain - interface: optional line capability used for refrigerated surcharge.
Insurable - interface: optional line capability used for insurance.
Returnable - interface: optional line capability used for return windows.
CheckoutException - class: checked parent for business refusals.
PaymentDeclinedException - class: checked parent for payment refusals.
Other exception types - classes: specific checked refusal categories.
Zone - enum: delivery region selection.
Coupon - class: validates and calculates capped discounts.
OrderLine - class: holds one chargeable unit, quantity, and line state.
DeliveryCalculator - class: calculates billed-weight and cold-chain delivery.
PriceBreakdown - record: immutable complete order price result.
Order - class: owns basket lines, pricing, atomic placement, and returns.
PaymentMethod - interface: interchangeable payment authorization contract.
Wallet - class: encapsulates wallet balance and debit/credit rules.
MobileWalletPayment, CardPayment, CashOnDeliveryPayment - classes: payment implementations.
Marketplace - class: records placed orders and performs settlement.
SellerPayout - record: immutable payout details for one seller.
SettlementReport - class: seller payout collection and platform revenue.
