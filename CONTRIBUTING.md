# Note-It
 Want to contribute to this repo? Follow the steps below to set-up the project in your local system, making changes and making a pull request.

## How to contribute (overall process)

1. Fork the project, using the gray `Fork` button in the top right of this page
2. Make any changes in your forked repo
3. On this repo, click `Pull Requests` (which is the third option at the top of this page after the options `Code` and `Issues`) and raise a Pull Request by clicking the green `New Pull Request` button and selecting your fork from the right drop down field.

Questions can be asked by raising an [Issue](https://github.com/unnikrishnan2002/Note-It/issues).

## How to clone repo and make changes locally after forking

- Click on the green `Code` button, then either the HTTPS or SSH option and click the icon to copy the URL. This will give you a copy of the project, so you can play around with it locally on your computer.

- Using Git on your local machine and paste in the URL. Do this to download the forked copy of this repo to your computer.

```
  git clone https://github.com/yourGithubUsername/Note-It.git
```

- Switch to the cloned folder. This can be done with Gitbash.

```
  cd Note-It
```

- Make a new branch. Your username would make a good branch because it's unique.

```
  git checkout -b <name-of-new-branch>
```

## Making desired changes

Now this is your copy of project. 
1. You can find the folder name `Noted-It` in one of your local drives. Open that folder in the IDE of your choice like VS Code.
2. Make the desired changes according to the issue that you have chosen to solve from the `Issues` section on the organization's github repo.
3. And you ready to be able see the changes that you have made in your forked copy of repo. Again follow the steps below.

## Getting changes to appear on forked github repo

- Stage your changes.

```
  git add .
```

- Commit the changes.

```
  git commit -m "Add <your-github-username>"
```

- Check the status of your repository.

```
  git status
```

- The response should be like this:

```
On branch <name-of-your-branch>
nothing to commit, working tree clean
```

- Pushing your repository to GitHub.

```
  git push origin <name-of-your-branch>
```

In case you get an error message like the one below, its likely you forgot to fork the repo before cloning it. To fix this, its best to start over with the How to Contribute section above, and fork the project repo first.

```
ERROR: Permission to unnikrishnan2002/Noted-It.git denied to <your-github-username>.
fatal: Could not read from remote repository.
Please make sure you have the correct access rights and the repository exists.
```

## Making a pull request

 On the GitHub website, navigate to your forked repo - on the top of the files section you'll notice a new section containing a `Compare & Pull Request` button!

- Click on that button and this will load a new page, comparing the local branch in your forked repo, against the main branch in the EddieHub Hacktoberfest repo. Accept the default values in the drop down boxes and click the green `Create Pull Request` button. After creating the PR (Pull Request) our GitHub Actions workflow will add a welcome message to your PR.
  Note: A pull request allows your changes to be merged with the original project repo.

- Wait for your changes to be merged.

Hurray! You successfully made a contribution! 🎉

---

## Creating an issue from a repository

1. On GitHub.com, navigate to the main page of the repository.
2. Under your repository name, click `Issues`.
3. Click `New issue`.
4. If your repository uses issue templates, click Get started next to the type of issue you'd like to open.
Or, click Open a blank issue if the type of issue you'd like to open isn't included in the available options.
5. Type a title and description for your issue.
6. If you're a project maintainer, you can assign the issue to someone, add it to a project board, associate it with a milestone, or apply a label.
7. When you're finished, click `Submit new issue`.

