package com.example.myapplication.network.serviceBuilder;

import java.util.Map;

public final class RepoHeader{
    RepoData repoData;

    protected RepoHeader(RepoData repoData){
        this.repoData = repoData;
    }

    public RepoObserver setHeader(Map<String, String> headers) {
        repoData.setHeader(headers);
        return new RepoObserver(repoData);
    }
}
