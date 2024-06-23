
.PHONY: compile package run


compile:
	mvn compile
package:
	mvn package
run:
	mvn clean javafx:run
