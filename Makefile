
JCC = javac
JFLAGS = -g -d


all: mytest runtest
BIN:
	if [ ! -d "bin" ]; then mkdir bin; fi;
SRC:
	if [ ! -d "src" ]; then mkdir src; fi;

CLASS:
	if [ ! -d "class" ]; then mkdir class; fi;

TEST:
	if [ ! -d "test" ]; then mkdir test; fi;

mytest: maketest runtest

maketest: BIN SRC CLASS TEST
	$(JCC) $(JFLAGS) class src/Parser.java src/GedLine.java src/GedObject.java src/Note.java src/DateTime.java src/HelloWorld.java

runtest:
	cd class; \
	java HelloWorld

clean:
	if [ -d "bin" ]; then rm -rf ./bin/; fi;
