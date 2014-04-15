(ns sicp-clojure.exercise_01_01-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_01 :refer :all]))

(deftest ex_01_01-test
  (testing "Equality"     (is (= 10 10)))
  (testing "Addition"     (is (= (+ 5 3 4) 12)))
  (testing "Subtraction"  (is (= (- 9 1) 8)))
  (testing "Division"     (is (= (/ 6.0 2) 3.0)))
  (testing "Multiply"     (is (= (+ (* 2 4) (- 4 6)) 6)))
  (testing "Import a"     (is (= a 3)))
  (testing "Import b"     (is (= b 4)))
  (testing "MultPlus"     (is (= (+ a b (* a b)) 19)))
  (testing "Inequality"   (is (not (= a b))))
  (testing "If"           (is (= (if (and (> b a) (< b (* a b)))
                                      b
                                      a) 4)))
  (testing "cond" (is (= (cond (= a 4) 6
                               (= b 4) (+ 6 7 a)
                               :else 25) 16)))
  (testing "inline if"   (is (= (+ 2 (if (> b a) b a)) 6)))
  (testing "inline cond" (is (= (* (cond (> a b) a
                                         (< a b) b
                                         :else -1)
                                   (+ a 1)) 16)))
)
