cat instance-types_en.nt | grep "<http://dbpedia.org/ontology/Person>" | sed --expression 's/ <http:\/\/www.w3.*//' > persons.txt



cat instance-types_en.nt | grep "<http://dbpedia.org/ontology/Flim>" | sed --expression 's/ <http:\/\/www.w3.*//' > flims.txt


cat instance-types_en.nt | grep "<http://dbpedia.org/ontology/Mountain>" | sed --expression 's/ <http:\/\/www.w3.*//' > Mountain.txt


cat instance-types_en.nt | grep "<http://dbpedia.org/ontology/Organisation>" | sed --expression 's/ <http:\/\/www.w3.*//' > Organisation.txt

cat instance-types_en.nt | grep "<http://dbpedia.org/ontology/MilitaryConflict>" | sed --expression 's/ <http:\/\/www.w3.*//' > MilitaryConflict.txt


cat instance-types_en.nt | grep "<http://dbpedia.org/ontology/Airport>" | sed --expression 's/ <http:\/\/www.w3.*//' > Airport.txt


cat instance-types_en.nt | grep "<http://dbpedia.org/ontology/Species>" | sed --expression 's/ <http:\/\/www.w3.*//' > Species.txt


MilitaryConflict

