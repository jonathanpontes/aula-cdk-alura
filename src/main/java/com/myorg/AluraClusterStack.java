package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.IVpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.constructs.Construct;

public class AluraClusterStack extends Stack {
    private Cluster cluster;
    /* Criando um cluster com uma vpc criaada usando cdk

    public AluraClusterStack(final Construct scope, final String id, Vpc vpc) {
        this(scope, id, null, vpc);
    }

    public AluraClusterStack(final Construct scope, final String id, final StackProps props, Vpc vpc) {
        super(scope, id, props);



        Cluster cluster = Cluster.Builder.create(this, "AluraCluster")
                .clusterName("cluster-alura")
                .vpc(vpc)
                .build();
    }*/


    // Criando um cluster com uma vpc buscada usando cdk
    public AluraClusterStack(final Construct scope, final String id, final IVpc vpc) {
        this(scope, id, null, vpc);
    }

    public AluraClusterStack(final Construct scope, final String id, final StackProps props, IVpc vpc) {
        super(scope, id, props);

        cluster = Cluster.Builder.create(this, "AluraCluster")
                .clusterName("cluster-alura")
                .vpc(vpc)
                .build();
    }

    Cluster getCluster() {
        return cluster;
    }
}