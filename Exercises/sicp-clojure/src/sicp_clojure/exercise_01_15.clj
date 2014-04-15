(ns sicp-clojure.exercise_01_15
  (:gen-class))

(defn cube [x] (* x x x))

(defn p [x] (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (Math/abs angle) 0.1))
      angle
      (p (sine (/ angle 3.0)))))

; a) How many times is the procedure p applied when (sine 12.15) is evaluated?
;    It will be evaluated the number of times it takes to get 12.15 down to less
;    than 0.1 by progressive divisions by 3, so:
;    12.15, 4.05, 1.35, 0.45, 0.15, 0.05 => 5 times (not called on 0.05).
;
; b) The order of growth is logarithmic. (Increases by 1 for every multiple of 3 of n)
;
;    Though even that is a bit misleading, because we should be pre-limiting
;    the angle, because angle in radians is modulo (2 * Pi).  So we could
;    reduce the problem given in (a) by finding 12.15 mod (2Pi) = 5.86681469282041
;
;    So with a precursor reduction of the angle, the order of growth becomes O(1).