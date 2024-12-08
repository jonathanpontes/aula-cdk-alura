package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.IVpc;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcLookupOptions;
import software.constructs.Construct;
import software.amazon.awscdk.Environment;

public class AluraVpcStack extends Stack {
    //Criação de vpc
    //private Vpc vpc;

    //Busca de vpc
    private IVpc vpc;

    //Criação de vpc
    /*public AluraVpcStack(final Construct scope, final String id) {
        this(scope, id, null);
    }*/

    public AluraVpcStack(final Construct scope, final String id) {
        this(scope, id, StackProps.builder()
                .env(Environment.builder()
                        .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
                        .region(System.getenv("CDK_DEFAULT_REGION"))
                        .build())
                .build());
    }

    public AluraVpcStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

      /*  CRIANDO UMA NOVA VPC

      Vpc vpc = Vpc.Builder.create(this, "AluraVPC")
                .maxAzs(3)  // Default is all AZs in region
                .build();*/

      // BUSCANDO UMA VPC EXISTENTE
        vpc = Vpc.fromLookup(this, "ExistingVPC", VpcLookupOptions.builder()
                .vpcId("vpc-046b54e5065449ca0")
                .build());

    }

    /*public Vpc getVpc() {
        return vpc;
    }*/

    public IVpc getVpc() {
        return vpc;
    }
}
