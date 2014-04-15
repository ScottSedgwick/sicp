(ns sicp-clojure.exercise_01_08-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_08 :refer :all]))

(defn near [a b]
  (< (Math/abs (- a b)) 0.001))

(deftest ex_01_08-test
  (testing "Cbrt" (is (near (cbrt 27) 3)))
  (testing "Sqrt" (is (near (sqrt 9) 3)))
)