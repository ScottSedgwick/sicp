(ns sicp-clojure.exercise_02_02-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_02_02 :refer :all]))

(deftest ex_02_02-test
  (testing "Point 1"   (is (= (show-point p1) "(0,3)")))
  (testing "Point 2"   (is (= (show-point p2) "(2,1)")))
  (testing "Start Seg" (is (= (show-point (start-segment s)) "(0,3)")))
  (testing "End Seg"   (is (= (show-point (end-segment s)) "(2,1)")))
  (testing "Show Seg"  (is (= (show-segment s) "[(0,3),(2,1)]")))
  )