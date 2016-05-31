(def alphabet "abcdefghijklmnopqrstuvwxyz")

(defn circle-shift
  "Сдвигаем первый символ строки в конец"
  [s]
  (apply str(concat (rest s) [(first s)])))

(circle-shift alphabet)

; todo тест для circle-shift
