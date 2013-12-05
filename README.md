Develop a mini web application with some minimal RDBMS backend, and an unconventional UX.

Backend:
* set up a single MySQL database with a single table containing two columns: integer ID, text CONTENT, integer POSITION
* populate some data manually (10-15 records)
* develop a classic 3-tier Java web application that allows two operations detailed below (you can use any component available in the Spring framework)

Front-end:
* there is a single screen that lists the records: display a table with the ID's and the first 30 characters of the CONTENT, sorted by POSITION
* allow drag and drop on the table:
** user can resort the table and the updated POSITION's are written back to the DB
** user can drag a record out(!) of the browser window. in this case the full CONTENT is written to a text-file called "${ID}.txt"
*** make an additional research: is it possible to display some UI between the "drop" event and actually writing the file, to ask the user for some additional parameters? (you can e.g. ask him to enter the filename)

Requirements:
* keep things simple
* use Spring as much as it can help to solve the problem
* use jQuery as much as it can help to solve the problem
* browser families to support: Chrome, Firefox, multiple variations of IE (going even back to IE7) - if some of those can't support this, explain why not

Deliverables:
* full source code
* WAR (it must be a drop-in deploy to Tomcat and some easy configuration for the JDBC URL)
* SQL to create the schema
* installation instructions 

