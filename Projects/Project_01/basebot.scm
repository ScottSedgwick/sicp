;;; Project 1, 6.001, Spring 2005

;;; idea is to simulate a baseball robot

;; imagine hitting a ball with an initial velocity of v 
;; at an angle alpha from the horizontal, at a height h
;; we would like to know how far the ball travels.

;; as a first step, we can just model this with simple physics
;; so the equations of motion for the ball have a vertical and a 
;; horizontal component

;; the vertical component is governed by
;; y(t) = v sin alpha t + h - 1/2 g t^2 
;; where g is the gravitational constant of 9.8 m/s^2

;; the horizontal component is governed by
;; x(t) = v cos alpha t
;; assuming it starts at the origin

;; First, we want to know when the ball hits the ground
;; this is governed by the quadratic equation, so we just need to know when 
;; y(t)=0 (i.e. for what t_impact is y(t_impact)= 0).
;; note that there are two solutions, only one makes sense physically

(define square
  (lambda (x) (* x x)))

;; these are constants that will be useful to us
(define gravity 9.8)  ;; in m/s
(define pi 3.14159)

;; Unit testing suite
(load "check.scm")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Problem 1

(define position
  (lambda (a v u t)
    (+ (/ (* a (square t)) 2) (* v t) u)
  )
)

;; you need to complete this procedure, then show some test cases

(define (posn-test)
  (check (position 00 00 00 00) => 00)
  (check (position 00 00 20 00) => 20)
  (check (position 00 05 10 10) => 60)
  (check (position 02 02 02 02) => 10)
  (check (position 05 05 05 05) => (/ 185 2))
  (check-report)
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Problem 2

(define (rootn a b c op)
  (define b2-4ac (- (square b) (* 4 a c)))
  (if (< b2-4ac 0)
    #f 
    (/ (op (- b) (sqrt b2-4ac)) (* 2 a))))

(define (root1 a b c)
  (rootn a b c +))

(define (root2 a b c)
  (rootn a b c -))

; Unit tests:
(define (root-test)
  (check (root1 2 3 4)     => #f)
  (check (root1 4 3 4)     => #f)
  (check (root1 4 8 4)     => (- 1))
  (check (root2 4 8 4)     => (- 1))
  (check (root1 2 8 2)     => (- .2679491924311228))
  (check (root2 2 8 2)     => (- 3.732050807568877))
  (check (root2 1 8 1)     => (- 7.872983346207417))
  (check (root1 1 8 1)     => (- .12701665379258298))
  (check (root1 1 30 1)    => (- .03337045290423468))
  (check (root2 1 30 1)    => (- 29.966629547095764)) 
  (check (root2 1 (- 2) 1) => 1) 
  (check (root1 1 (- 2) 1) => 1) 
  (check (root1 1 (- 3) 1) => 2.618033988749895) 
  (check (root2 1 (- 3) 1) => .3819660112501051) 
  (check-report)
)


; Above here is good.  Below, not so much.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Problem 3

(define (time-to-impact vertical-velocity elevation)
  (define a (- (/ gravity 2)))
  (define b vertical-velocity)
  (define c elevation)
  (define t1 (root1 a b c))
  (define t2 (root2 a b c))
  (cond ((not t1) t2)
        ((not t2) t1)
        ((> t1 t2) t1)
        (else t2)))

;; Note that if we want to know when the ball drops to a particular height r 
;; (for receiver), we have

(define time-to-height
  (lambda (vertical-velocity elevation target-elevation)
    (time-to-impact vertical-velocity (- elevation target-elevation))
  )
)

; Unit tests:
(define (time-test)
  (check (time-to-impact 0.0 4.9) => 1.0)
  (check (time-to-impact 9.8 0.000000000000001) => 2.0)
  (check (time-to-height 9.8 0.0 4.9) => 1.0)
  (check-report)
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Problem 4

;; once we can solve for t_impact, we can use it to figure out how far the ball went

;; conversion procedure
(define degree2radian
  (lambda (deg)
    (/ (*  deg pi) 180.)))

(define travel-time-simple
  (lambda (elevation velocity angle)
    (define vertical-velocity (* velocity (sin (degree2radian angle))))
    (time-to-height vertical-velocity elevation 0)
  )
)

(define travel-distance-simple
  (lambda (elevation velocity angle)
    (define travel-time (travel-time-simple elevation velocity angle))
    (define horizontal-velocity (* velocity (cos (degree2radian angle))))
    (* travel-time horizontal-velocity)
  )
)

;; let's try this out for some example values.  Note that we are going to 
;; do everything in metric units, but for quaint reasons it is easier to think
;; about things in English units, so we will need some conversions.

(define meters-to-feet
  (lambda (m)
    (/ (* m 39.6) 12)))

(define feet-to-meters
  (lambda (f)
    (/ (* f 12) 39.6)))

(define hours-to-seconds
  (lambda (h)
    (* h 3600)))

(define seconds-to-hours
  (lambda (s)
    (/ s 3600)))

;; what is time to impact for a ball hit at a height of 1 meter
;; with a velocity of 45 m/s (which is about 100 miles/hour)
;; at an angle of 0 (straight horizontal)
;; at an angle of (/ pi 2) radians or 90 degrees (straight vertical)
;; at an angle of (/ pi 4) radians or 45 degrees
(define err-range 0.001)
(define check-zeroish
  (lambda (value)
    (check (< (abs value) err-range) => #t)
  )
)

(define (travel-test)
  (check (travel-time-simple 1.0 45.0  0.0) => 0.4517539514526256)
  (check (travel-time-simple 1.0 45.0 90.0) => 9.205842177978788)
  (check (travel-time-simple 1.0 45.0 45.0) => 6.52510983052591)
  (check (travel-distance-simple 1.0 45.0  0.0) => 20.32892781536815)
  (check-zeroish (travel-distance-simple 1.0 45.0 90.0)) 
  (check (travel-distance-simple 1.0 45.0 45.0) => 207.6278611514906)
  (check-report)
)
;; what is the distance traveled in each case?
;; record both in meters and in feet

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Problem 5

;; these sound pretty impressive, but we need to look at it more carefully

;; first, though, suppose we want to find the angle that gives the best
;; distance
;; assume that angle is between 0 and (/ pi 2) radians or between 0 and 90
;; degrees

(define alpha-increment 0.01)

(define (larger a b) (if (> a b) a b))

(define find-best-angle
  (lambda (velocity elevation)
    (define (d a) (travel-distance-simple elevation velocity a))
    (define (help-best-angle angle end-angle current-best-angle current-best-distance)
      (if (> angle end-angle)
        current-best-angle
        (if (> (d angle) current-best-distance)
          (help-best-angle (+ angle 1) end-angle angle (d angle))
          (help-best-angle (+ angle 1) end-angle current-best-angle current-best-distance)
        )
      )
    )
    (help-best-angle 0 90 0 0)
  )
)

;; find best angle
;; try for other velocities
;; try for other heights

(define (fba-test)
  (check (larger 3 4) => 4)
  (check (larger 6 2) => 6)
  (check (find-best-angle 10.0 0.0) => 45)
  (check (find-best-angle 20.0 0.0) => 45)
  (check (find-best-angle 30.0 0.0) => 45)
  (check (find-best-angle 40.0 0.0) => 45)
  (check (find-best-angle 50.0 0.0) => 45)
  (check (find-best-angle 30.0 10.0) => 42)
  (check (find-best-angle 30.0 20.0) => 40)
  (check (find-best-angle 30.0 30.0) => 38)
  (check (find-best-angle 30.0 40.0) => 36)
  (check-report)
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Problem 6

;; problem is that we are not accounting for drag on the ball (or on spin 
;; or other effects, but let's just stick with drag)
;;
;; Newton's equations basically say that ma = F, and here F is really two 
;; forces.  One is the effect of gravity, which is captured by mg.  The
;; second is due to drag, so we really have
;;
;; a = drag/m + gravity
;;
;; drag is captured by 1/2 C rho A vel^2, where
;; C is the drag coefficient (which is about 0.5 for baseball sized spheres)
;; rho is the density of air (which is about 1.25 kg/m^3 at sea level 
;; with moderate humidity, but is about 1.06 in Denver)
;; A is the surface area of the cross section of object, which is pi D^2/4 
;; where D is the diameter of the ball (which is about 0.074m for a baseball)
;; thus drag varies by the square of the velocity, with a scaling factor 
;; that can be computed

;; We would like to again compute distance , but taking into account 
;; drag.
;; Basically we can rework the equations to get four coupled linear 
;; differential equations
;; let u be the x component of velocity, and v be the y component of velocity
;; let x and y denote the two components of position (we are ignoring the 
;; third dimension and are assuming no spin so that a ball travels in a plane)
;; the equations are
;;
;; dx/dt = u
;; dy/dt = v
;; du/dt = -(drag_x/m + g_x)
;; dv/dt = -(drag_y/m + g_y)
;; we have g_x = - and g_y = - gravity
;; to get the components of the drag force, we need some trig.
;; let speeed = (u^2+v^2)^(1/2), then
;; drag_x = - drag * u /speed
;; drag_y = - drag * v /speed
;; where drag = beta speed^2
;; and beta = 1/2 C rho pi D^2/4
;; note that we are taking direction into account here

;; we need the mass of a baseball -- which is about .15 kg.

;; so now we just need to write a procedure that performs a simple integration
;; of these equations -- there are more sophisticated methods but a simple one 
;; is just to step along by some step size in t and add up the values

;; dx = u dt
;; dy = v dt
;; du = - 1/m speed beta u dt
;; dv = - (1/m speed beta v + g) dt

;; initial conditions
;; u_0 = V cos alpha
;; v_0 = V sin alpha
;; y_0 = h
;; x_0 = 0

;; we want to start with these initial conditions, then take a step of size dt
;; (which could be say 0.1) and compute new values for each of these parameters
;; when y reaches the desired point (<= 0) we stop, and return the distance (x)

(define drag-coeff 0.5)
(define density 1.25)  ; kg/m^3
(define mass .145)  ; kg
(define diameter 0.074)  ; m
(define beta (* .5 drag-coeff density (* 3.14159 .25 (square diameter))))
(define gravity (- 9.8))

(define (nth n lst) 
  (if (= n 1)
    (car lst)
    (nth (- n 1) (cdr lst))
  )
)

(define (first lst)  (nth 1 lst))
(define (second lst) (nth 2 lst))
(define (third lst)  (nth 3 lst))
(define (fourth lst) (nth 4 lst))

(define integrate
  (lambda (x0 y0 u0 v0 dt g m beta)
    (define dx (* u0 dt))
    (define dy (* v0 dt))
    (define speed (sqrt (+ (square u0) (square v0))))
    (define du (* (/ (- 1) m) speed u0 beta))
    (define dv (* (+ (* (/ (- 1) m) speed v0 beta) g) dt))
    (define x1 (+ x0 dx))
    (define y1 (+ y0 dy))
    (define u1 (+ u0 du))
    (define v1 (+ v0 dv))
    (list x1 y1 u1 v1)
  )
)

(define (integrate-helper x y u v dt g m beta)
  (define lst (integrate x y u v dt g m beta))
  (define x1 (+ x (first  lst)))
  (define y1 (+ y (second lst)))
  (define u1 (+ u (third  lst)))
  (define v1 (+ v (fourth lst)))
  (if (<= y1 0)
    x1
    (integrate-helper x1 y1 u1 v1 dt g m beta)
  )
)

(define (horizontal-velocity angle velocity)
  (* velocity (cos (degree2radian angle)))
)

(define (vertical-velocity angle velocity)
  (* velocity (sin (degree2radian angle)))
)

(define (travel-distance angle velocity elevation)
  (define u0 (horizontal-velocity angle velocity))
  (define v0 (vertical-velocity angle velocity))
  (integrate-helper 0 elevation u0 v0 0.1 gravity mass beta)
)

(define (td-test)
  (check (integrate 0 0 1 1 1 gravity mass beta) => '(1 1 .986891591368892 -8.81310840863111))
  (check (integrate 0 9.8 0 0 1 gravity mass beta) => '(0 0 0 -9.81310840863111))
  (check (< (abs (- (vertical-velocity 30 2) 1.0)) 0.0001) => #t)
  (check (< (abs (- (vertical-velocity 45 (sqrt 2)) 1.0)) 0.0001) => #t)
  (check (< (abs (- (horizontal-velocity 30 2) (sqrt 3))) 0.0001) => #t)
  (check (< (abs (- (horizontal-velocity 45 (sqrt 2)) 1.0)) 0.0001) => #t)
  ; (check (travel-distance 45 10 0.1) => 10)
  (check-report)
)

;; RUN SOME TEST CASES

;; what about Denver?

;; Problem 7
 
;; now let's turn this around.  Suppose we want to throw the ball.  The same
;; equations basically hold, except now we would like to know what angle to 
;; use, given a velocity, in order to reach a given height (receiver) at a 
;; given distance


;; a cather trying to throw someone out at second has to get it roughly 36 m
;; (or 120 ft) how quickly does the ball get there, if he throws at 55m/s,
;;  at 45m/s, at 35m/s?

;; try out some times for distances (30, 60, 90 m) or (100, 200, 300 ft) 
;; using 45m/s

;; Problem 8

;; Problem 9
