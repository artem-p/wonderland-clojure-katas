(ns alphabet-cipher.coder)

(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")


(def alphabet [\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z])

(defn circle-shift
  "Сдвигаем первый символ строки в конец"
  [s]
  (vec (concat (rest s) [(first s)])))
(circle-shift alphabet)

(= (circle-shift alphabet) [\b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z \a])
(= (circle-shift [\b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z \a])
   [\c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z \a \b])
(= (circle-shift [\c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z \a \b])
   [\d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z \a \b \c])


;; sconessconessco
;; meetmebythetree
;; egsgqwtahuiljgs

(def message "meetmebythethree")
(def key-word "scones" )

;; m e e t m e b y t h   e   t   r   e   e
;; 1 2 3 4 5 6 7 8 9 10  11  12  13  14  15
;; 1 2 3 4 5 6 1 2 3 4   5   6   1   2   3

(defn get-pos-in-keyword
  "Для индекса символа в сообщении получаем индекс в ключевом слове"
  [index-in-message keyword-len]
  ;; Если номер меньше или равен длине ключевого слова, возвращаем его. Если больше, вызываем еще раз, вычитая из номера длину ключевого слова
  (if (<= index-in-message keyword-len) index-in-message (get-pos-in-keyword (- index-in-message keyword-len) keyword-len)))

(= (get-pos-in-keyword 1 6) 1)
(= (get-pos-in-keyword 2 6) 2)
(= (get-pos-in-keyword 6 6) 6)
(= (get-pos-in-keyword 7 6) 1)
; todo еще проверки
