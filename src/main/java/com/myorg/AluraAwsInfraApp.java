package com.myorg;

import software.amazon.awscdk.App;

public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();


        //Cria VPC
        AluraVpcStack vpcStack = new AluraVpcStack(app, "Vpc");
        //Cria Cluster
        AluraClusterStack clusterStack = new AluraClusterStack(app, "Cluster", vpcStack.getVpc());
        //Adiciona dependencia do VPC no Cluster
        clusterStack.addDependency(vpcStack);
        //Cria Serviço
        AluraServiceStack serviceStack = new AluraServiceStack(app, "Service", clusterStack.getCluster());
        //Adiciona dependencia do Serviço no Cluster
        serviceStack.addDependency(clusterStack);
        app.synth();
    }
}

