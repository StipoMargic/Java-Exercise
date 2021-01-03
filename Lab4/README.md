echo "POST http://localhost:8080/sensor
Content-Type: application/json
@/home/stipo/Dev/java-lab-2020-StipoMargic/Lab4/src/main/java/com/example/lab4/vegeta.json" | vegeta attack -header "authorization: Bearer 08472e00-2dc4-428f-94c4-ab1c2a9c7fff" -duration=40s -rate=10 -output=results-veg-token.bin && cat results-veg-token.bin | vegeta plot --title="HTTP Get with token" > http-get-token.html