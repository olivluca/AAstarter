# AAstarter

This app waits for a trigger from [my fork of AAGateWay](https://github.com/olivluca/AAGateWay) and starts Android Auto instructing it to connect back to AAGateway.

You can build it or get it from the [Releases](https://github.com/olivluca/AAstarter/releases) section and you have to install it on the master phone. 

# Play Protects kills the app

I noticed that Play Protects stops the app during its periodic scan since it considers it a
_potentially unwanted application_.

I'm not going to sign-up to the google developer program just for one single app, I'm not going to
disable play protect either, so I solved the problem with an [Automate](https://play.google.com/store/apps/details?id=com.llamalab.automate) macro that starts the service 
provided by the application when it connects to the slave's hotspot.

Any suggestion is welcome on how to disable play protect just for this app.
