class Notice {
    String channel ; // " EMAIL " , " SMS " , or " PUSH "
    String body ;
    // ... whoAmI getters ...
    transmit () {
        if ( channel == " EMAIL ") // build an e- mail line
else if ( channel == " SMS ") // split into segments , count them
else if ( channel == " PUSH ") // truncate for the lock screen
    }
    cost () {
        if ( channel == " EMAIL ") // free
else if ( channel == " SMS ") // per - segment charge
else if ( channel == " PUSH ") // flat
    }
}