(ns sicp-clojure.exercise_02_01-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_02_01 :refer :all]))

(deftest ex_02_01-test
  (testing "Print rational" (is (= (print-rat (add-rat one-third one-half))
                                   "5/6"))))