
JCC = javac
JFLAGS = -g


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
	$(JCC) $(JFLAGS) src/HelloWorld.java
	mv src/HelloWorld.class class;
	

runtest:
	cd class; \
	java HelloWorld

clean:
	if [ -d "bin" ]; then rm -rf ./bin/; fi;
