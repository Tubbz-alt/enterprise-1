## Camel REDHAWK Example
***

This example application shows how you can use Camel REDHAWK component to subscribe to an Event Channel and publish that data to a JMS Topic. 

### Set Up
***

In order to run this demo you need to setup the example component that will publish data to a REDHAWK Event Channel and the Waveform to run that component must be launched. Each of the project described below can be imported into REDHAWK using the 'REDHAWK Import Wizard' provided by the IDE. 

* EventSpitter: Sends out a struct every second. 
* SpitToChannel: Uses the EventSpitter component to send data to an EventChannel called EventsSpat

Once you've launched the SpitToChannel Waveform and ensure that it's been started. You can run the following command to see the event messages from your component:

    eventviewer REDHAWK_DEV EventsSpat
    
If you'd like the example to publish events to a ActiveMQ as well you'll need to install ActiveMQ on your machine or any machine your machine has access too. For more details on ActiveMQ checkout the following links:

* Download ActiveMQ from here: http://activemq.apache.org/download.html 

* Follow Getting Started here: http://activemq.apache.org/version-5-getting-started.html

### Example Output

	eventviewer REDHAWK_DEV EventsSpat
	Receiving events. Press 'enter' key to exit
	[{'id': 'properties', 'value': [{'id': 'foo', 'value': 'foo-04edebfc-6a8b-4f56-b018-25bbc46a842a'}, {'id': 'bar', 'value': 1.6000000238418579}]}]
	[{'id': 'properties', 'value': [{'id': 'foo', 'value': 'foo-09df6252-15fc-4af8-8e6e-5c6db2dbe3b5'}, {'id': 'bar', 'value': 1.6000000238418579}]}]
	[{'id': 'properties', 'value': [{'id': 'foo', 'value': 'foo-0c34db0e-4dae-4315-a344-73d50b8d2a8f'}, {'id': 'bar', 'value': 1.6000000238418579}]}]
	[{'id': 'properties', 'value': [{'id': 'foo', 'value': 'foo-38d514f1-29bc-4939-8b34-0e8e7246c0cb'}, {'id': 'bar', 'value': 1.6000000238418579}]}]
	[{'id': 'properties', 'value': [{'id': 'foo', 'value': 'foo-5cb7f365-1488-4130-8917-8b9b3f03430e'}, {'id': 'bar', 'value': 1.6000000238418579}]}]
	[{'id': 'properties', 'value': [{'id': 'foo', 'value': 'foo-a5ecffae-39dc-43a9-80ee-f3902dcd0929'}, {'id': 'bar', 'value': 1.6000000238418579}]}]


### Instructions
***

* Start KARAF 'rhjt/apache-karaf-4.0.8/bin/start'
* Add a configuration for REDHAWK by dropping the 'redhawk.datasource.factory-localRH.cfg' file into the etc directory of your karaf install.
* Add the camel route to the deploy directory of karaf
* Start the SpitToChannel waveform
* At this point you'll see logs of the messages being sent to the event channel in your karaf log

	2017-02-23 14:35:19,417 | INFO  | eadpool; w: Idle | eventTest                        | 31 - org.apache.camel.camel-core - 2.17.5 | Exchange[ExchangePattern: InOnly, BodyType: java.util.HashMap, Body: {bar=1.6, foo=foo-beff745f-6ab1-4d75-b5e3-a29a0c4e9a3d}]
	2017-02-23 14:35:20,548 | INFO  | eadpool; w: Idle | eventTest                        | 31 - org.apache.camel.camel-core - 2.17.5 | Exchange[ExchangePattern: InOnly, BodyType: java.util.HashMap, Body: {bar=1.6, foo=foo-fcda80f5-3b6b-46fb-8ada-80859ff7fcef}]
	2017-02-23 14:35:21,678 | INFO  | eadpool; w: Idle | eventTest                        | 31 - org.apache.camel.camel-core - 2.17.5 | Exchange[ExchangePattern: InOnly, BodyType: java.util.HashMap, Body: {bar=1.6, foo=foo-0dc62388-5dee-43b5-8c1b-7bfa91f2bc39}]
	2017-02-23 14:35:22,808 | INFO  | eadpool; w: Idle | eventTest                        | 31 - org.apache.camel.camel-core - 2.17.5 | Exchange[ExchangePattern: InOnly, BodyType: java.util.HashMap, Body: {bar=1.6, foo=foo-090be096-49ba-4943-ae65-3a4ae1438398}]
	2017-02-23 14:35:23,938 | INFO  | eadpool; w: Idle | eventTest                        | 31 - org.apache.camel.camel-core - 2.17.5 | Exchange[ExchangePattern: InOnly, BodyType: java.util.HashMap, Body: {bar=1.6, foo=foo-0dcc5772-0759-4122-ba11-fc7fe10c697f}]
	
**ActiveMQ Integration**
* Login to your karaf console and run the following commands:

	feature:repo-add mvn:org.apache.activemq/activemq-karaf/5.14.3/xml/features
	feature:install activemq-camel
	
* Now that ActiveMQ available to be used as a Camel Component uncomment the sections relevant to ActiveMQ in your route. Once your save the file the Camel Context will be redeployed automatically with your changes. 
* You can go to your ActiveMQ Admin console to confirm messages are being sent to the topic. 

	


		
