//
//  Feature.swift
//  iosApp
//
//  Created by stephen chacha on 24/10/2024.
//

import SwiftUI

struct Feature: Identifiable {
    let id = UUID()
    let title: String
    let imageName: String
    let category: String
    let destination: AnyView  // Destination screen for the feature
}

let allFeatures = [
        Feature(title: "Send Money", imageName: "paperplane.fill", category: "Transact", destination: AnyView(SendMoneyView())),
        Feature(title: "Bank Transfer", imageName: "arrow.right.arrow.left", category: "Transact", destination: AnyView(BankTransferView())),
        Feature(title: "Withdraw", imageName: "creditcard.fill", category: "Transact", destination: AnyView(WithdrawView())),
        Feature(title: "Loan", imageName: "dollarsign.circle.fill", category: "Transact", destination: AnyView(LoansView())),
        Feature(title: "Buy Airtime", imageName: "arrow.down.circle.fill", category: "Transact", destination: AnyView(BuyAirtimeView())),
        Feature(title: "Bill & Till Pay", imageName: "house.fill", category: "Transact", destination: AnyView(BillTillPayView())),
        Feature(title: "Travel Booking", imageName: "airplane.circle.fill", category: "Travel & Shop", destination: AnyView(TravelBookingView())),
        Feature(title: "Hotel Booking", imageName: "bed.double.fill", category: "Travel & Shop",destination: AnyView(HotelBookingView())),
        Feature(title: "Invest", imageName: "chart.bar.fill", category: "Invest & Save", destination: AnyView(InvestView())),
        Feature(title: "Save", imageName: "banknote.fill", category: "Invest & Save", destination: AnyView(SaveView()))
    ]


