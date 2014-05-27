all: NQueens.class Tab.class PrintTab.class
NQueens.class: NQueens.java
	javac -d . -classpath . NQueens.java
Tab.class: Tab.java
	javac -d . -classpath . Tab.java
PrintTab.class: PrintTab.java
	javac -d . -classpath . PrintTab.java
clean:
	rm -f *.class
	rm -f *queens*.txt 
