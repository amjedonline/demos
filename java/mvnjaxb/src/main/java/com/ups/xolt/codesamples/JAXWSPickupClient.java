/* 
 ** 
 ** Filename: JAXWSPickupClient.java 
 ** Authors: United Parcel Service of America
 ** 
 ** The use, disclosure, reproduction, modification, transfer, or transmittal 
 ** of this work for any purpose in any form or by any means without the 
 ** written permission of United Parcel Service is strictly prohibited. 
 ** 
 ** Confidential, Unpublished Property of United Parcel Service. 
 ** Use and Distribution Limited Solely to Authorized Personnel. 
 ** 
 ** Copyright 2009 United Parcel Service of America, Inc.  All Rights Reserved. 
 ** 
 */
package com.ups.xolt.codesamples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import com.ups.wsdl.xoltws.pickup.v1_1.PickupCreationErrorMessage;
import com.ups.wsdl.xoltws.pickup.v1_1.PickupPortType;
import com.ups.wsdl.xoltws.pickup.v1_1.PickupService;
import com.ups.xmlschema.xoltws.common.v1.RequestType;
import com.ups.xmlschema.xoltws.error.v1.CodeType;
import com.ups.xmlschema.xoltws.error.v1.ErrorDetailType;
import com.ups.xmlschema.xoltws.error.v1.Errors;
import com.ups.xmlschema.xoltws.pickup.v1.AccountType;
import com.ups.xmlschema.xoltws.pickup.v1.PhoneType;
import com.ups.xmlschema.xoltws.pickup.v1.PickupAddressType;
import com.ups.xmlschema.xoltws.pickup.v1.PickupCreationRequest;
import com.ups.xmlschema.xoltws.pickup.v1.PickupCreationResponse;
import com.ups.xmlschema.xoltws.pickup.v1.PickupDateInfoType;
import com.ups.xmlschema.xoltws.pickup.v1.PickupPieceType;
import com.ups.xmlschema.xoltws.pickup.v1.ShipperType;
import com.ups.xmlschema.xoltws.pickup.v1.WeightType;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity.ServiceAccessToken;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity.UsernameToken;

public class JAXWSPickupClient {

	private static String accesskey;
	private static String username;
	private static String password;
	private static String accountNumber;
	private static String out_file_location = "out_file_location";
	private static String tool_or_webservice_name = "tool_or_webservice_name";
	private static final String url = "url";
	static Properties props = null;
	private static String projPath = null;
	static {
		try {
			props = new Properties();
			File file = new File(
					"//Users//admin//Ent//workspace//mvnjaxb//src//main//resources//build.properties");
			props.load(new FileInputStream(file));
			accesskey = props.getProperty("accesskey");
			username = props.getProperty("username");
			password = props.getProperty("password");
			accountNumber = props.getProperty("accountnumber");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		String statusCode = null;
		String description = null;
		try {
			PickupService pkService = new PickupService();
			PickupPortType pkPort = pkService.getPickupPort();
			BindingProvider bp = (BindingProvider) pkPort;
			bp.getRequestContext().put(
					BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					props.getProperty(url));
			PickupCreationRequest pickupCreationRequest = new PickupCreationRequest();
			RequestType requestType = new RequestType();
			List<String> requestOption = requestType.getRequestOption();
			requestOption.add("  ");
			pickupCreationRequest.setRequest(requestType);

			pickupCreationRequest.setRatePickupIndicator("N");

			ShipperType shipper = new ShipperType();
			AccountType account = new AccountType();
			account.setAccountCountryCode("IT");
			account.setAccountNumber(accountNumber);
			shipper.setAccount(account);
			pickupCreationRequest.setShipper(shipper);

			PickupDateInfoType pickupDateInfo = new PickupDateInfoType();
			pickupDateInfo.setCloseTime("2000");
			pickupDateInfo.setPickupDate("20131030");
			pickupDateInfo.setReadyTime("0900");
			pickupCreationRequest.setPickupDateInfo(pickupDateInfo);

			PickupAddressType pickupAddress = new PickupAddressType();
			List<String> addressLine = pickupAddress.getAddressLine();
			addressLine.add("315 Termin");
			pickupAddress.setCity("Rome");
			pickupAddress.setCompanyName("Pickup Proxy");
			pickupAddress.setContactName("Pickup Manage");
			pickupAddress.setCountryCode("IT");
			pickupAddress.setRoom("R01");
			pickupAddress.setFloor("2");
			pickupAddress.setStateProvince("RM");
			pickupAddress.setPostalCode("00134");
			pickupAddress.setPickupPoint("Termin");
			pickupAddress.setResidentialIndicator("Y");
			pickupCreationRequest.setPickupAddress(pickupAddress);
			pickupCreationRequest.setAlternateAddressIndicator("N");

			PhoneType phoneType = new PhoneType();
			phoneType.setExtension("911");
			phoneType.setNumber("6785851306");
			pickupAddress.setPhone(phoneType);

			List<PickupPieceType> pickupPiece = pickupCreationRequest
					.getPickupPiece();
			PickupPieceType pickupType = new PickupPieceType();
			pickupType.setContainerCode("01");
			pickupType.setDestinationCountryCode("IT");
			pickupType.setQuantity("1");
			pickupType.setServiceCode("011");
			pickupPiece.add(pickupType);

			WeightType totalWeight = new WeightType();
			totalWeight.setUnitOfMeasurement("LBS");
			totalWeight.setWeight("5.5");
			pickupCreationRequest.setTotalWeight(totalWeight);
			pickupCreationRequest.setOverweightIndicator("N");

			pickupCreationRequest.setPaymentMethod("00");
			pickupCreationRequest
					.setSpecialInstruction("Handle with care, Deliver with a Smile please..!!!!");

			/** ************UPSSE ***************************/
			UPSSecurity upss = new UPSSecurity();
			ServiceAccessToken token = new ServiceAccessToken();
			token.setAccessLicenseNumber(accesskey);
			upss.setServiceAccessToken(token);
			UsernameToken usernameToken = new UsernameToken();
			usernameToken.setPassword(password);
			usernameToken.setUsername(username);
			upss.setUsernameToken(usernameToken);
			/** ************UPSSE ******************************/

			PickupCreationResponse PickupResponse = pkPort
					.processPickupCreation(pickupCreationRequest, upss);
			statusCode = PickupResponse.getResponse().getResponseStatus()
					.getCode();
			description = PickupResponse.getResponse().getResponseStatus()
					.getDescription();
			updateResultsToFile(statusCode, description);
			System.out.println("The transaction was a "
					+ PickupResponse.getResponse().getResponseStatus()
							.getDescription());

		} catch (PickupCreationErrorMessage avE) {
			Errors errs = avE.getFaultInfo();
			List<ErrorDetailType> errDetailList = errs.getErrorDetail();
			ErrorDetailType aError = errDetailList.get(0);

			CodeType primaryError = aError.getPrimaryErrorCode();
			description = primaryError.getDescription();
			statusCode = primaryError.getCode();
			updateResultsToFile(statusCode, description);
			System.out.println("\nThe Error Response: Code=" + statusCode
					+ " Decription=" + description);
		} catch (Exception e) {
			description = e.getMessage();
			statusCode = e.toString();
			updateResultsToFile(statusCode, description);
			e.printStackTrace();
		}
	}

	/**
	 * This method updates the XOLTResult.xml file with the received status and
	 * description
	 * 
	 * @param statusCode
	 * @param description
	 */
	private static void updateResultsToFile(String statusCode,
			String description) {
		BufferedWriter bw = null;
		try {

			File outFile = new File(props.getProperty(out_file_location));
			System.out.println("Output file deletion status: "
					+ outFile.delete());
			outFile.createNewFile();
			System.out.println("Output file location: "
					+ outFile.getCanonicalPath());
			bw = new BufferedWriter(new FileWriter(outFile));
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("<ExecutionAt>");
			strBuf.append(Calendar.getInstance().getTime());
			strBuf.append("</ExecutionAt>\n");
			strBuf.append("<ToolOrWebServiceName>");
			strBuf.append(props.getProperty(tool_or_webservice_name));
			strBuf.append("</ToolOrWebServiceName>\n");
			strBuf.append("\n");
			strBuf.append("<ResponseStatus>\n");
			strBuf.append("\t<Code>");
			strBuf.append(statusCode);
			strBuf.append("</Code>\n");
			strBuf.append("\t<Description>");
			strBuf.append(description);
			strBuf.append("</Description>\n");
			strBuf.append("</ResponseStatus>");
			bw.write(strBuf.toString());
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
					bw = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
