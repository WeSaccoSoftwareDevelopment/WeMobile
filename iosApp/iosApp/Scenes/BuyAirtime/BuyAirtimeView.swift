//
//  BuyAirtimeView.swift
//  iosApp
//
//  Created by stephen chacha on 24/10/2024.
//

import SwiftUI

import SwiftUI

struct BuyAirtimeView: View {
    @State private var selectedAccount: String = ""
    @State private var phoneNumber: String = ""
    @State private var amount: String = ""
    @State private var isForSomeoneElse = false

    var body: some View {
        VStack(alignment: .leading){
            // Pay With
            HStack {
                Text("Pay With")
                    .font(.headline)
                Spacer()
            }
            .padding(.horizontal)
            
            HStack {
                TextField("Select account", text: $selectedAccount)
                    .padding()
                    .overlay(
                        RoundedRectangle(cornerRadius: 8)
                            .stroke(Color.gray, lineWidth: 1)
                    )
                Spacer()
                Image(systemName: "chevron.right")
                    .foregroundColor(.gray)
            }
            .padding()

            // Buy Airtime For
            VStack(alignment: .leading) {
                Text("Buy Airtime For:")
                    .font(.headline)
                    .padding(.horizontal)
                
                HStack {
                    Button(action: {
                        isForSomeoneElse = false
                    }) {
                        HStack {
                            Image(systemName: isForSomeoneElse ? "circle" : "checkmark.circle.fill")
                                .foregroundColor(isForSomeoneElse ? .gray : .green)
                            Text("Myself")
                        }
                    }
                                        
                    Button(action: {
                        isForSomeoneElse = true
                    }) {
                        HStack {
                            Image(systemName: isForSomeoneElse ? "checkmark.circle.fill" : "circle")
                                .foregroundColor(isForSomeoneElse ? .green : .gray)
                            Text("Someone Else")
                        }
                    }
                }
                .padding(.horizontal)
            }
            .padding(.top)

            // Phone Number and Amount Input
            VStack {
                if isForSomeoneElse {
                    TextField("Phone Number", text: $phoneNumber)
                        .keyboardType(.phonePad)
                        .padding()
                        .overlay(
                            RoundedRectangle(cornerRadius: 8)
                                .stroke(Color.gray, lineWidth: 1)
                        )
                        .padding(.horizontal)
                }

                TextField("Amount", text: $amount)
                    .keyboardType(.numberPad)
                    .padding()
                    .overlay(
                        RoundedRectangle(cornerRadius: 8)
                            .stroke(Color.gray, lineWidth: 1)
                    )
                    .padding(.horizontal)
                
                Text("Minimum amount is Ksh 1")
                    .foregroundColor(.gray)
                    .font(.footnote)
                    .padding(.top, 2)
                    .padding(.trailing,210)
    
            }

            // Continue Button
            Button(action: {
                // Handle continue action
            }) {
                Text("Continue")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.gray.opacity(0.6))
                    .cornerRadius(8)
                    .foregroundColor(.white)
                    .padding(.horizontal)
            }
            .padding(.top, 20)
            
            Spacer()
        }
        .navigationBarTitle("Buy Airtime", displayMode: .inline)
        .padding(.top)
    }
}

struct BuyAirtimeView_Previews: PreviewProvider {
    static var previews: some View {
        BuyAirtimeView()
    }
}

