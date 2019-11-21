# TTA

Use cases:
1. user can add game result
2. user authentication
3. tournament signup
4. draw to divisions and leagues
5. public result view
6. generate tournament schedule
7. compute final standings in tournament
8. historization of results
9. user can register into app (tta/app-username, nationality, e-mail)


1. user can add game result
- result entry should be possible for 2-4 players
- for every player there should be these values: place, culture points, replaced by AI flag
- if player is replaced by AI he is placed last and he score 0 championship points
- if player resign he has 0 culture points but can score championship points
- if players are tied in culture points, championship points are evenly divided between them
- if results are not correctly send and are obtained from CGE support then all player get penalty -1 championship point
- default scoring for 3-player is: 5/2/0
- default scoring for 4-player is: 6/3/1/0
- create test where player replaced by AI is added on 1st position with some culture points but his result will be properly evaluated
