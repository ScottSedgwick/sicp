(ns-name *ns*)

(defn numer [x] (first x))

(defn denom [x] (first (rest x)))

(defn add-rat [x y]
	(make-rat (+ (* (numer x) (denom y))
		        (* (numer y) (denom x)))
	          (* (denom x) (denom y))))

(defn sub-rat [x y]
	(make-rat (- (* (numer x) (denom y))
		        (* (numer y) (denom x)))
	          (* (denom x) (denom y))))

(defn mul-rat [x y]
	(make-rat (* (numer x) (numer y))
	          (* (denom x) (denom y))))

(defn div-rat [x y]
	(make-rat (* (numer x) (denom y))
	          (* (denom x) (numer y))))

(defn equal-rat? [x y]
	(= (* (numer x) (denom y))
	   (* (denom x) (numer y))))

(defn print-rat [x]
  (clojure.string/join "/" [(numer x), (denom x)]))

(defn gcd [a b]
  (if (= b 0)
      a
      (gcd b (rem a b))))

(defn make-rat [n d]
  (defn helper [n d]
    (let [g (gcd n d)]
	     (cons (/ n g) [(/ d g)])))
  (cond (< d 0) (helper (- n) (- d))
        :else   (helper n d)))

(def one-third (make-rat 1 3))
(def one-half  (make-rat 1 2))

(print-rat (add-rat one-third one-half))

