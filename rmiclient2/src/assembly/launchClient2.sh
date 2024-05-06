#!/bin/sh

echo "Attente de 10 secondes avant l'exécution..."
sleep 10

java -Djava.security.policy=scripts/java.policy -jar rmiClient2-0.0.1-SNAPSHOT.jar