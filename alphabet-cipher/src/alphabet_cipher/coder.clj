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
;; 0 1 2 3 4 5 6 7 8 9   10  11  12  13  14
;; 0 1 2 3 4 5 0 1 2 3   4   5   0   1   2   3

(defn get-pos-in-keyword
  "Для индекса символа в сообщении получаем индекс в ключевом слове"
  [index-in-message keyword-len]
  ;; Если номер меньше длины ключевого слова, возвращаем его. Если больше, вызываем еще раз, вычитая из номера длину ключевого слова
  (if (< index-in-message keyword-len) index-in-message (get-pos-in-keyword (- index-in-message keyword-len) keyword-len)))


(defn get-keyword-letter
  "Получаем букву ключевого слова по индексу символа сообщения"
  [index-in-message key-word]
  (get key-word (get-pos-in-keyword index-in-message (count key-word)))
  )

(= (get-keyword-letter 1 "abc") \b)
(= (get-keyword-letter 2 "abc") \c)
(= (get-keyword-letter 3 "abc") \a)

(= (get-keyword-letter 0 "scones") \s)
(= (get-keyword-letter 7 "scones") \c)

;; todo
;; Есть символ ключевого слова.
;; Определяем его номер в алфавите
;; Столько раз вызываем circle-shift
;; Определяем номер в алфавите символа исходного сообщения
;; Получаем по этому номеру символ в сдвинутом алфавите

(defn get-index-in-alphabet
  "Получаем индекс символа в алфавите"
  [c]
  (.indexOf [\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z] c)
  )

(= (get-index-in-alphabet \a) 0)
(= (get-index-in-alphabet \z) 25)

(defn get-shifted-alphabet-for-symbol
  "Получаем сдвинутый алфавит для символа"
  [c]
  (last (take (+ (get-index-in-alphabet c) 1) (iterate circle-shift alphabet))))


(last (take 10 (iterate circle-shift alphabet)))
(get-shifted-alphabet-for-symbol \a)


(= (get-shifted-alphabet-for-symbol \a) [\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z])
(= (get-shifted-alphabet-for-symbol \z) [\z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y])


;; (= (get-pos-in-keyword 1 6) 1)
;; (= (get-pos-in-keyword 2 6) 2)
;; (= (get-pos-in-keyword 6 6) 6)
;; (= (get-pos-in-keyword 7 6) 1)
;; (= (get-pos-in-keyword 9 6) 3)
;; (= (get-pos-in-keyword 14 6) 2)
; todo еще проверки
