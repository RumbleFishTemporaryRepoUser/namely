Uruchomienie przez metodę main w RumbleFishApplication. Wymagana Java 18 i maven 3.8.4

Przykładowy curl na dodanie imienia:

curl --location --request POST 'localhost:8080' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"Patrick"
}'

Przykładowy curl na pobranie ostatniego imienia

curl --location --request GET 'localhost:8080'

P.S. ten plik można ładniej 
zformatować i opisać dokładniej jak uruchomić aplikację.
Oprócz tego można zmienić endpointy, np. dodając do ścieżki /person lub /guest
i chociażby /v1, jakby się chciało mieć odpowiednio wersjonowane api.
