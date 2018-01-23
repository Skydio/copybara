import static org.junit.Assert.fail;
import com.google.common.collect.Maps;
import java.util.Map;
    options = getOptionsBuilder(console);
    git("init", "--bare", repoGitDir.toString());
  public OptionsBuilder getOptionsBuilder(
      TestingConsole console) throws IOException {
    return new OptionsBuilder()
        .setConsole(this.console)
        .setOutputRootToTmpDir();
  }

    return GitRepository.newBareRepo(path, getEnv(), /*verbose=*/true);
  }

  private Map<String, String> getEnv() {
    Map<String, String> env = Maps.newHashMap(options.general.getEnvironment());
    env.putAll(getGitEnv());
    return env;
        .matchesNext(MessageType.PROGRESS, "Git Destination: Fetching: file:.* refs/heads/master")
        .matchesNext(MessageType.WARNING,
            "Git Destination: 'refs/heads/master' doesn't exist in 'file://.*")
    thrown.expectMessage("'refs/heads/testPullFromRef' doesn't exist");

    // Wait a second so that the git log history is ordered.
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      fail("Interrupted while waiting: " + e.getMessage());
    }
    branchChange(scratchTree, scratchRepo, "b2", "b2-1\n\n"
        + DummyOrigin.LABEL_NAME + ": b2-origin");
    branchChange(scratchTree, scratchRepo, "b2", "b2-2");
    GitRepository localRepo = GitRepository.newRepo(true, localPath, getEnv()).init(