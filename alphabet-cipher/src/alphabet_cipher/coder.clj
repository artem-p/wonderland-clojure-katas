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
