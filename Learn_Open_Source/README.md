# Learning_Open_Source

[Useful articles for new Open Source contributors](https://github.com/freeCodeCamp/how-to-contribute-to-open-source#:~:text=the%20Mozilla%20ecosystem.-,Useful%20articles%20for%20new%20Open%20Source%20contributors,-Helpful%20articles%20and)

## [Contributing, step by step](https://www.nearform.com/blog/getting-into-open-source-for-the-first-time/#:~:text=Contributing%2C%20step%20by%20step)

- Create a fork
- Clone a local copy
- Set up remote tracking
  - needs to track both your remote repository as well as the original repository it was forked from
  - By default, only track to your copy but not the original fork
  - `git remote add upstream https://github.com//.git`
- Create a feature branch
  - `git checkout -b name-of-branch`
- Commit contributions
- Prepare pull request
  - `git checkout master`: Your copy of the original repository will invariably become stale. This is to keep up to date.
  - `git pull --rebase upstream master`: We need to rebase our master branch so that it matches the upstream master branch.
  - `git push -f origin master`: Rebase is destructive and may rewrite your current master branch. This is ok since we always want our master to be in line with the upstream. We need to tell Git to force update our remote fork
  - `git checkout my-branch && git rebase master`: Check out our feature branch and rebase it with our local copy of master. place them at the end of the commit list. The importance of this will become apparent when we create our PR, the receiving repo will see our commits on top of theirs which makes merging much easier.
- PR
- Having your code reviewed
- Handling rework requests
- Acceptance
- Clean up
  - `git checkout master && git pull --rebase upstream master && git push -f origin master`: This is to keep your repository in sync as above
  - `git branch -D my_branch git push origin --delete my_branch`

## Advanced Markdown

diff block

```diff
- const data = []
+ const data = {}
```

- [ ] check list 1
- [x] check list 2

[text to display](http://google.com/)

| column 1 | column 2 | column 3 |
| :------- | :------: | -------: |
| left     |  middle  |    right |

## Shields.io

![GitHub Repo stars](https://img.shields.io/github/stars/ZhengLin-Li/Learning_Repo?style=social)

<img alt="GitHub followers" src="https://img.shields.io/github/followers/ZhengLin-Li?style=for-the-badge">

## [Finding ways to contribute to open source on GitHub](https://docs.github.com/en/get-started/exploring-projects-on-github/finding-ways-to-contribute-to-open-source-on-github)

Topics

Explore

Finding good first issues: `github.com/<owner>/<repository>/contribute`

<!-- test git rebase -->


| :—-: | :—-: | :—-: | 

| OpenStreetMap | 7 | 3 |








| orgnization name | project proposed | project accepted |
| :------- | :------: | -------: |
| left     |  middle  |    right |





<img align="left"  width="350"  src="https://github-readme-stats.vercel.app/api?username=Zhenglin-Li&show_icons=true&theme=gotham" alt="abhisheknaiidu" />