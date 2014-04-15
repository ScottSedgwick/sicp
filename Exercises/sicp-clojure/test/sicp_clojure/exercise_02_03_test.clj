(ns sicp-clojure.exercise_02_03-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_02_03 :refer :all]
            [sicp-clojure.exercise_02_02 :as e22]))

(def tl (e22/make-point 0 3))
(def tr (e22/make-point 2 3))
(def br (e22/make-point 2 1))
(def bl (e22/make-point 0 1))
(def r (make-rect tl tr br bl))

(deftest ex_02_03-test
  (testing "Display Rect" (is (= (display-rect r)
                                 "[(0,3),(2,3)]:[(2,3),(2,1)]:[(2,1),(0,1)]:[(0,1),(0,3)]")))
  (testing "Perimeter"    (is (= (perimeter r) 8.0)))
  (testing "Area"         (is (= (area r) 4.0)))
)