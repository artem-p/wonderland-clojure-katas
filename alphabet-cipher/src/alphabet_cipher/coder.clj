(ns alphabet-cipher.coder)

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


(get-shifted-alphabet-for-symbol \a)


(= (get-shifted-alphabet-for-symbol \a) [\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z])
(= (get-shifted-alphabet-for-symbol \z) [\z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y])

(defn get-keyword-string
  "Получаем строку с повторяющимся ключевым словом такой же длины, как исходное сообщение
  Вначале повторяем его столько раз, чтобы было точно больше или равно длине сообщения. Например столько,
  сколько символов в сообщении. Потоб обрезаем"
  [message key-word]
  (subs (apply str (repeat(count message) key-word)) 0 (count message))
  )

( =(get-keyword-string "message" "keyword"), "keyword")
( =(get-keyword-string "messageme" "keyword"), "keywordke")
( =(get-keyword-string "messageme" "abc"), "abcabcabc")
( =(get-keyword-string "short" "longer"), "longe")

(defn encode-single
  "Кодируем один символ по символу исходного сообщения и символу ключевого слова"
  ;; Есть символ ключевого слова.
  ;; Определяем его номер в алфавите
  ;; Столько раз вызываем circle-shift
  ;; Определяем номер в алфавите символа исходного сообщения
  ;; Получаем по этому номеру символ в сдвинутом алфавите
  [message-symbol keyword-symbol]
  (get (get-shifted-alphabet-for-symbol message-symbol) (get-index-in-alphabet keyword-symbol))
)


;; sconessconessco
;; meetmebythetree
;; egsgqwtahuiljgs

(defn encode [key-word message]
  ;; Получаем последовательность ключевого слова sconessconesscone
  ;; Делаем map по двум последовательностям
  (apply str (map encode-single (seq message) (seq (get-keyword-string message key-word))))
)

(encode "scones" "meetmebythetree")

(defn decode-single
  "Декодируем один символ по символу сообщения и символу ключевого слова"
  [message-symbol keyword-symbol]
  ;; Получаем сдвинутый алфавит для символа ключевого слова
  ;; В нем находим символ сообщения, получаем его индекс
  ;; Берем символ из алфавита с этим индексом - будет раскодированный символ
  (get alphabet (.indexOf (get-shifted-alphabet-for-symbol keyword-symbol) message-symbol))
  )

(= (decode-single \e \s) \m)
(= (decode-single \w \e) \s)
(= (decode-single \s \e) \o)

(defn decode [key-word message]
  (apply str (map decode-single (seq message) (seq (get-keyword-string message key-word))))
  )

(decode "scones" "egsgqwtahuiljgs")

(defn decipher-single
  ;; Это как decode, только меняем местами аргументы
  [message-symbol cipher-symbol]
  (decode-single cipher-symbol message-symbol))

(= (decipher-single \m \e) \s)
(= (decipher-single \e \g) \c)
(= (decipher-single \e \s) \o)

(defn get-repeated-keyword
  "Повторяющееся ключевое слово sconessconessco"
  [cipher message]
  (apply str (map decipher-single (seq message) (seq cipher)))

  )

(= (get-repeated-keyword "egsgqwtahuiljgs" "meetmebythetree") "sconessconessco")
