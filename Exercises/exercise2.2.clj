(defn x-point [p]
  (first p))

(defn y-point [p]
  (first (rest p)))

(defn show-point [p]
  (clojure.string/join "" ["(",
                           (x-point p),
                           ",",
                           (y-point p),
                           ")"]))

(defn print-point [p]
  (println "")
  (println (show-point p)))

(defn make-segment [p1 p2]
  (cons p1 [p2]))

(defn start-segment [s]
  (first s))

(defn end-segment [s]
  (first (rest s)))

(defn make-point [x y]
  (cons x [y]))

(defn show-segment [s]
  (clojure.string/join "" ["[",
                           (start-segment s),
                           ",",
                           (end-segment s),
                           "]"]))

(defn print-segment [s]
  (println "")
  (println (show-segment s)))

(def p1 (make-point 0 3))
(def p2 (make-point 2 1))

(def s (make-segment p1 p2))
(show-point p1)
(show-point p2)
(show-point (start-segment s))
(show-point (end-segment s))
(show-segment s)
