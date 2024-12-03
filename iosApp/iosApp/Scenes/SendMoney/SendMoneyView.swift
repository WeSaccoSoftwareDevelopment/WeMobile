//
//  SendMoneyView.swift
//  iosApp
//
//  Created by stephen chacha on 24/10/2024.
//

import SwiftUI

import SwiftUI

struct SendMoneyView: View {
    @State private var selectedAccount: String = ""
    @State private var paymentMethod: String = "M-PESA"
    @State private var phoneNumber: String = ""
    @State private var amount: String = ""
    
    var body: some View {
        VStack {
            // Header
            HStack {
                Button(action: {
                    // Add back button action here
                }) {
                    Image(systemName: "arrow.left")
                        .font(.title2)
                        .foregroundColor(.primary)
                }
                Spacer()
                Text("Send Money")
                    .font(.headline)
                Spacer()
                // Empty space for symmetry
                Image(systemName: "arrow.left")
                    .font(.title2)
                    .foregroundColor(.clear)
            }
            .padding()

            Form {
                // Pay With Section
                Section(header: Text("Pay With")) {
                    NavigationLink(destination: Text("Select Account Screen")) {
                        HStack {
                            Text(selectedAccount.isEmpty ? "Select account" : selectedAccount)
                                .foregroundColor(selectedAccount.isEmpty ? .gray : .primary)
                            Spacer()
                            Image(systemName: "chevron.right")
                        }
                    }
                }
                
                // Send To Section
                Section(header: Text("Send to")) {
                    Picker(selection: $paymentMethod, label: Text(paymentMethod)) {
                        Text("M-PESA").tag("M-PESA")
                        Text("Bank Transfer").tag("Bank Transfer")
                    }
                    .pickerStyle(MenuPickerStyle())
                    
                    TextField("Phone Number", text: $phoneNumber)
                        .keyboardType(.phonePad)
                    
                    TextField("Amount", text: $amount)
                        .keyboardType(.decimalPad)
                        .overlay(
                            Text("Minimum amount is Ksh 1")
                                .font(.caption)
                                .foregroundColor(.gray)
                                .padding(.top, 32),
                            alignment: .bottomLeading
                        )
                }
            }
            
            Spacer()
            
            // Continue Button
            Button(action: {
                // Continue action
            }) {
                Text("Continue")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(isContinueEnabled() ? Color.green : Color.gray)
                    .foregroundColor(.white)
                    .cornerRadius(8)
            }
            .padding(.horizontal)
            .disabled(!isContinueEnabled())
        }
        .navigationBarHidden(true)
    }
    
    // Logic to enable/disable Continue button
    private func isContinueEnabled() -> Bool {
        return !selectedAccount.isEmpty && !phoneNumber.isEmpty && !amount.isEmpty
    }
}

struct SendMoneyView_Previews: PreviewProvider {
    static var previews: some View {
        SendMoneyView()
    }
}

