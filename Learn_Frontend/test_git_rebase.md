THIS IS TO TEST GIT REBASE

Situation now:
- local git branch `dev` and `master` are pushed
- local git branch `dev` and `master` are up to date
- origin's (aka Github) `master` branch is modified

Action:
- at local, run the following code:
- `git checkout master`
- `git pull --rebase origin master`
- `git checkout dev`
- `git rebase master`

Result:
- to be continued...
