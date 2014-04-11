(:use "exercise2.2.clj")

(defn make-rect [top-left top-right bottom-right bottom-left]
  [top-left top-right bottom-right bottom-left])

(defn top-left [r]
  (first r))

(defn top-right [r]
  (first (rest r)))

(defn bottom-right [r]
  (first (rest (rest r))))

(defn bottom-left [r]
  (first (rest (rest (rest r)))))

(defn top [r]
  (make-segment (top-left r) (top-right r)))

(defn right [r]
  (make-segment (top-right r) (bottom-right r)))

(defn bottom [r]
  (make-segment (bottom-right r) (bottom-left r)))

(defn left [r]
  (make-segment (bottom-left r) (top-left r)))

(defn display-rect [r]
  (clojure.string/join ":" [(show-segment (top r)),
                            (show-segment (right r)),
                            (show-segment (bottom r)),
                            (show-segment (left r))]))

(defn square [x]
  (Math/pow x 2))

(defn length-segment [s]
  (Math/sqrt (+ (square (- (x-point (start-segment s))
                           (x-point (end-segment s))))
                (square (- (y-point (start-segment s))
                           (y-point (end-segment s)))))))

(defn perimeter [r]
  (* 2
    (+ (length-segment (top r))
       (length-segment (right r)))))

(defn area [r]
  (* (length-segment (top r))
     (length-segment (right r))))

(def tl (make-point 0 3))
(def tr (make-point 2 3))
(def br (make-point 2 1))
(def bl (make-point 0 1))
(def r (make-rect tl tr br bl))
(display-rect r)
(perimeter r)
(area r)
