(ns sicp-clojure.exercise_02_03
  (:gen-class))

(require '[sicp-clojure.exercise_02_02 :as e22])

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
  (e22/make-segment (top-left r) (top-right r)))

(defn right [r]
  (e22/make-segment (top-right r) (bottom-right r)))

(defn bottom [r]
  (e22/make-segment (bottom-right r) (bottom-left r)))

(defn left [r]
  (e22/make-segment (bottom-left r) (top-left r)))

(defn display-rect [r]
  (clojure.string/join ":" [(e22/show-segment (top r)),
                            (e22/show-segment (right r)),
                            (e22/show-segment (bottom r)),
                            (e22/show-segment (left r))]))

(defn square [x]
  (Math/pow x 2))

(defn length-segment [s]
  (Math/sqrt (+ (square (- (e22/x-point (e22/start-segment s))
                           (e22/x-point (e22/end-segment s))))
                (square (- (e22/y-point (e22/start-segment s))
                           (e22/y-point (e22/end-segment s)))))))

(defn perimeter [r]
  (* 2
    (+ (length-segment (top r))
       (length-segment (right r)))))

(defn area [r]
  (* (length-segment (top r))
     (length-segment (right r))))