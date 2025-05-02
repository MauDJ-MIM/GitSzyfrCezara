# Uruchamianie i testowanie projektu

(tutaj pojawi się opis)

# Szyfr Cezara

(tutaj pojawi się opis)

# Kodowanie Huffmana

[Kodowanie Huffmana](https://en.wikipedia.org/wiki/Huffman_coding) jest popularną, prostą metodą kompresji danych, która wykorzystuje różnice w częstotliwości występowania różnych znaków, by tym występującym najczęściej przydzielić najkrótsze kody. Powstałe kody nie są stałej szerokości (różne znaki mogą mieć reprezentację różne długości), ale są prefix-free (wolne od prefiksów), więc reprezentacja żadnego znaku nie jest prefiksem reprezentacji innego (czyli nie ma problemu z dekodowaniem).

Klasa `HuffmanCoding` z pliku `HuffmanCoding.java` służy do kodowania i dekodowania z użyciem kodu Huffmana. Aby skonstruować obiekt klasy, można wprost podać częstotliwości występowania różnych znaków obliczone dla danego kontekstu (np. języka, dialektu, typu pliku...) lub podać fragment tekstu, na podstawie którego mają zostać wyliczone.

Metoda `.encode(String text)` zwraca ciąg zer i jedynek - zakodowany tekst. Metoda `.decode(String text)` przyjmuje zakodowany tekst złożony z zer i jedynek i zwraca odkodowany tekst.

Aby móc odkodować zakodowany tekst, trzeba znać częstotliwości występowania znaków, które zostały użyte do zakodowania. Do ich pobrania (szczególnie gdy zostały wyliczone przez klasę na podstawie podanego tekstu) służy metoda `.getFrequencies()`, która zwraca typ `HashMap<Character, Double>`.
