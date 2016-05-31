(def alphabet "abcdefghijklmnopqrstuvwxyz")


(seq alphabet)

(concat (rest alphabet) [(first alphabet)])

;; let([alphabet "abcdefghijklmnopqrstuvwxyz"]
;;     (concat (rest alphabet) [(first alphabet)]))
