Uruchomienie przez metodę main w RumbleFishApplication. Wymagana Java 18 i maven 3.8.4

Przykładowy curl na dodanie imienia:

curl --location --request POST 'localhost:8080' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"Patrick"
}'

Przykładowy curl na pobranie ostatniego imienia

curl --location --request GET 'localhost:8080'

[comment]: <> (ten plik można ładniej 
zformatować i opisać dokładniej jak uruchomić aplikację.
oprócz tego można dodać jakieś ścieżki do endpointów, np. /person
czy też /v1, jakby się chciało mieć odpowiednio wersję api)