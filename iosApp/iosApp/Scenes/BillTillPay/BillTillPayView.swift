//
//  BillTillPayView.swift
//  iosApp
//
//  Created by stephen chacha on 24/10/2024.
//

import SwiftUI

struct BillTillPayView: View {
    @State private var selectedAccount = "Fosa Savings Account"
    @State private var businessNumber = ""
    @State private var accountNumber = ""
    @State private var amount = ""
    
    var body: some View {
        VStack {
        
            // Tabs
            HStack {
                Button(action: {
                    // Action for Buy Goods
                }) {
                    Text("Buy Goods")
                        .foregroundColor(.gray)
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, 10)
                }
                
                Button(action: {
                    // Action for Pay Bill
                }) {
                    Text("Pay Bill")
                        .foregroundColor(.green)
                        .fontWeight(.bold)
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, 10)
                }
            }
            .background(Color.black.opacity(0.1))
            
            // Pay With Section
            VStack(alignment: .leading) {
                Text("Pay With")
                    .font(.headline)
                    .foregroundColor(.white)
                    .padding(.top)
                
                HStack {
                    Text(selectedAccount)
                        .foregroundColor(.white)
                        .padding()
                    Spacer()
                    Image(systemName: "chevron.right")
                        .foregroundColor(.gray)
                }
                .background(Color.black.opacity(0.1))
                .cornerRadius(10)
                
                // Form Fields
                Group {
                    TextField("Business Number", text: $businessNumber)
                        .padding()
                        .background(Color.black.opacity(0.1))
                        .cornerRadius(10)
                        .keyboardType(.numberPad)
                    
                    TextField("Account Number", text: $accountNumber)
                        .padding()
                        .background(Color.black.opacity(0.1))
                        .cornerRadius(10)
                        .keyboardType(.numberPad)
                        .overlay(
                            HStack {
                                Spacer()
                                Text("\(accountNumber.count)/20")
                                    .foregroundColor(.gray)
                                    .padding(.trailing, 10)
                            }
                        )
                    
                    TextField("Amount", text: $amount)
                        .padding()
                        .background(Color.black.opacity(0.1))
                        .cornerRadius(10)
                        .keyboardType(.decimalPad)
                }
                .foregroundColor(.white)
            }
            .padding()
            
            // Continue Button
            Button(action: {
                // Action for Continue
            }) {
                Text("Continue")
                    .foregroundColor(.gray)
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.black.opacity(0.3))
                    .cornerRadius(10)
            }
            .padding(.horizontal)
            .padding(.top)
            
            // Frequent Section
            VStack(alignment: .leading) {
                Text("Frequent")
                    .font(.headline)
                    .foregroundColor(.white)
                    .padding(.horizontal)
                
                FrequentItemView(accountName: "Equity Paybill Account", businessNumber: "247247", color: .orange)
                FrequentItemView(accountName: "KCB Paybill Account", businessNumber: "522522", color: .blue)
                FrequentItemView(accountName: "Co-operative Bank Collection Account", businessNumber: "400222", color: .purple)
                FrequentItemView(accountName: "KPLC PREPAID", businessNumber: "888880", color: .cyan)
            }
            .padding(.horizontal)
            
            Spacer()
        }
        .foregroundColor(.white)
    }
}

// Custom View for Frequent Items
struct FrequentItemView: View {
    var accountName: String
    var businessNumber: String
    var color: Color
    
    var body: some View {
        HStack {
            Text(accountName.prefix(2))
                .font(.title)
                .bold()
                .frame(width: 50, height: 50)
                .background(color)
                .foregroundColor(.white)
                .clipShape(Circle())
            VStack(alignment: .leading) {
                Text(accountName)
                    .font(.subheadline)
                    .bold()
                Text(businessNumber)
                    .font(.subheadline)
                    .foregroundColor(.gray)
            }
            Spacer()
        }
        .padding(.vertical, 5)
    }
}


#Preview {
    BillTillPayView()
}
