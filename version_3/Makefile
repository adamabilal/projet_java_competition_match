author: Adama TRAORE Esam SHARFELDIN

cls:
		javac -encoding utf8 -d cls -cp cls -classpath junit-4.3.jar main/*.java util/*.java  test/*.java

clean:

		rm -rf  cls  doc

doc:

		javac  -d doc -cp doc  main/*.java util/*.java


tests:
	java -jar junit-platform-console-standalone-1.8.1.jar -cp test --scan-class-path --disable-banner


jar: 
		jar cvmf manifest-ex master.jar cls/main/*.class cls/util/*.class

M16:
		java -jar master.jar  M16  Saint-Étienne Lyon Clermont Montpellier Marseille Nice Monaco Troyes Bordeaux Paris Reims Metz Strasbourg Angers Nantes Rennes

M24:

	    java -jar master.jar  M24  Saint-Étienne Lyon Clermont Montpellier Marseille Nice Monaco Troyes Bordeaux Paris Reims Metz Strasbourg Angers Nantes Rennes  Lens Lille Lorient Brest saint-quentin Artois Valencienne Barca 


M32:

	    java -jar master.jar  M32

