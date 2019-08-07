package com.example.simpleapp.network.serviceBuilder;

public final class RepoUrl {
    RepoData repoData;
    protected RepoUrl(RepoData repoData){
        this.repoData = repoData;
    }
    public RepoResponseClass setUrl(String url){
        repoData.setUrl(url);
        return new RepoResponseClass(repoData);
    }
}
