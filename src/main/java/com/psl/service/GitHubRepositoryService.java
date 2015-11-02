/**
 * Copy right by Persistent PVT LTD
 */
package com.psl.service;

import java.util.ArrayList;
import java.util.List;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GitHub;
import com.psl.model.RepositoryFile;
import com.psl.model.UserDetails;

/**
 * @author Praveen G K
 *
 */
public class GitHubRepositoryService implements GitHubRepositoryServiceImpl {

	final String gitPrefixUrl = "https://github.com/";
	final String urlSplitString1 = "blob/master/";
	final String urlSplitString2 = "tree/master/";
	final static String FILE = "FILE";
	final static String DIRECTORY = "DIRECTORY";

	public UserDetails gitHubRepositoryStructure(UserDetails userDetails) {
		List<RepositoryFile> currentBranchTree = new ArrayList<RepositoryFile>();
		List<GHContent> contentList = null;
		String path = userDetails.getUrl();
		String[] urlArray = null;
		if (path != null) {
			path = path.replace(gitPrefixUrl, "");
			urlArray = splitGitURL(path);
			try {
				GHContent ghContent = GitHub
						.connectUsingPassword(userDetails.getUserName(),
								userDetails.getPassword())
						.getRepository(urlArray[0]).getFileContent(urlArray[1]);
				userDetails.setUrlAccessible(true);
				if (ghContent.isFile()) {
					RepositoryFile file = new RepositoryFile(
							ghContent.getName(), ghContent.getHtmlUrl(),
							isFileOrDirectory(ghContent));
					file.setFileContent(ghContent.getContent());
					currentBranchTree.add(file);
				}
			} catch (Exception e) {
				try {

					contentList = GitHub
							.connectUsingPassword(userDetails.getUserName(),
									userDetails.getPassword())
							.getRepository(urlArray[0])
							.getDirectoryContent(urlArray[1]);
					userDetails.setUrlAccessible(true);

					for (GHContent content : contentList) {
						currentBranchTree.add(new RepositoryFile(content
								.getName(), content.getHtmlUrl(),
								isFileOrDirectory(content)));
					}

				} catch (Exception ie) {
					userDetails.setUrlAccessible(false);

					return userDetails;
				}
			}
			userDetails.setRepositoryFiles(currentBranchTree);
		}
		return userDetails;

	}

	public String isFileOrDirectory(GHContent content) {
		if (content.isFile())
			return FILE;
		if (content.isDirectory())
			return DIRECTORY;
		return null;
	}

	public String[] splitGitURL(String url) {
		String[] urlArray = new String[2];
		String[] tempUrlArray = null;
		if (url.contains(urlSplitString1)) {
			tempUrlArray = url.split(urlSplitString1);
		} else {
			tempUrlArray = url.split(urlSplitString2);
		}
		urlArray[0] = tempUrlArray[0];
		if (tempUrlArray.length > 1) {
			urlArray[1] = tempUrlArray[1];
		} else {
			urlArray[1] = "";
		}
		return urlArray;
	}

}
