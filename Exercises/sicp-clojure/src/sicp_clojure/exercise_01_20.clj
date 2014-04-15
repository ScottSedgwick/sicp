(ns sicp-clojure.exercise_01_20
  (:gen-class))

(defn gcd [a b]
  (if (= b 0) a (gcd b (remainder a b))))

; Normal Order evaluation:
; ========================
; (gcd 206 40)
; (gcd 40 (remainder 206 40))
;    => (remainder 206 40) is evalutated in if => 6
; (gcd (remainder 206 40) (remainder 40 (remainder 206 40)))
;    (remainder 40 (remainder 206 40)) is evalutaed in if => 4
; (gcd ((remainder 40 (remainder 206 40)) (remainder (remainder 206 40) (remainder 40 (remainder 206 40)))))
;   => (remainder (remainder 206 40) (remainder 40 (remainder 206 40))) is evaluated in if => 2
; (gcd (remainder (remainder 206 40) (remainder 40 (remainder 206 40)))
;      (remainder (remainder 40 (remainder 206 40)) (remainder (remainder 206 40) (remainder 40 (remainder 206 40)))))
;   => (remainder (remainder 40 (remainder 206 40)) (remainder (remainder 206 40) (remainder 40 (remainder 206 40)))
;      is evaluated in if => 0
; (remainder (remainder 206 40) (remainder 40 (remainder 206 40)))
; (remainder 6 (remainder 40 (remainder 206 40)))
; (remainder 6 (remainder 40 6))
; (remainder 6 4)
; 2

; Applicative Order evaluation:
; =============================
; (gcd 206 40)
;   (remainder 206 40)
; (gcd 40 6)
;   (remainder 40 6)
; (gcd 6 4)
;   (remainder 6 4)
; (gcd 4 2)
;   (remainder 4 2)
; 2