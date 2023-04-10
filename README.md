# AutomaticIrrigationSystem-1
BM Task

# Irrigation System
This is a project for managing an irrigation system. It is built using Spring Boot and Angular.

# Requirements
* Java 11 or higher
* Node.js 12 or higher
* Angular CLI 15 or higher
* H2 Database


# Getting Started
To install the angular packages, navigate to src/main/resources/frontend:

<pre><code>
npm install
</code></pre> 

To build the angular scripts

<pre><code>
ng build
</code></pre> 

To start the backend server, navigate to the root directory and run:

<pre><code>
./mvnw spring-boot:run
</code></pre> 


# Alert System
AutoIrrigationAlertScheduler class is Scheduler runs every 30 seconds and can be configured from application.yml

# Reports
please check application.yml

* D://Report//alert-plot.csv
* D://Report//auto-irrigation-plot.csv

# Logging
please check application.yml
* D://Report//AutoIrrigation-App.log

# Usage
Once the server is running, you can access the application at http://localhost:8080/irrigation/index.html

# Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

# License
https://choosealicense.com/licenses/mit/ 






