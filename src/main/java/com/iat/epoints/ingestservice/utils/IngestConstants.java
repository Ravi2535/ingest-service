package com.iat.epoints.ingestservice.utils;

public interface IngestConstants {

	String APPLICATION_NAME = "scale-up-poc";
	String SERVICE_ACCOUNT_USER = "rajesh@scale-up.vision";
	String BULK_ROUTE_SQS_CONFIGURATION = "aws-sqs://arn:aws:sqs:ap-south-1:762323811421:user?accessKey=AKIAISD4KYVV35IHCNEA&secretKey=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";
	String NEWUSER_ROUTE_SQS_CONFIGURATION = "aws-sqs://arn:aws:sqs:ap-south-1:762323811421:newUser?accessKey=AKIAISD4KYVV35IHCNEA&secretKey=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";
	String EDITED_USER_ROUTE_SQS_CONFIGURATION = "aws-sqs://arn:aws:sqs:ap-south-1:762323811421:editedUser?accessKey=AKIAISD4KYVV35IHCNEA&secretKey=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";
	String DELETED_USER_ROUTE_SQS_CONFIGURATION = "aws-sqs://arn:aws:sqs:ap-south-1:762323811421:deletedUser?accessKey=AKIAISD4KYVV35IHCNEA&secretKey=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";
}
