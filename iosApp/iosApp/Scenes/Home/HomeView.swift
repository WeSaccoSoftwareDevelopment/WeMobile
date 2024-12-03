//
//  HomeView.swift
//  iosApp
//
//  Created by stephen chacha on 23/10/2024.
//

import SwiftUI

struct HomeView: View {
    @State private var balance = 80.55
    @State private var accountNumber = "0123456789"
    
    var columns: [GridItem] = [
        GridItem(.flexible(), spacing: nil, alignment: nil),
        GridItem(.flexible(), spacing: nil, alignment: nil)
    ]
    
    var body: some View {
        NavigationView {
            ScrollView{
                VStack(alignment: .leading) {
                    
                    HStack {
                        VStack(alignment: .leading) {
                            Text("Hey,")
                                .foregroundColor(.gray)
                            Text("STEPHEN")
                                .font(.title)
                                .bold()
                        }
                        Spacer()
                        Image(systemName: "person.circle.fill")
                            .resizable()
                            .frame(width: 40, height: 40)
                            .foregroundColor(.white)
                    }
                    .padding(.horizontal)
                    .padding(.top)
                    
                    // Balance Section
                    VStack(alignment: .leading) {
                        Text("Stephen Chacha Marwa")
                            .font(.headline)
                        HStack {
                            Text("\(balance, specifier: "%.2f")KES")
                                .font(.title)
                                .bold()
                            Spacer()
                            Image(systemName: "person.crop.circle")
                                .foregroundColor(.gray)
                        }
                        Text(accountNumber + " • Saving")
                            .foregroundColor(.green)
                            .font(.subheadline)
                    }
                    .padding()
                    .background(Color.black.opacity(0.1))
                    .cornerRadius(10)
                    .padding(.top)

                    LazyVGrid(columns: columns){
                        HomeComponent(
                            imageName: "house.fill",
                            title: "Paysomeone",
                            subTitle: "To Wallet bank,or mobile number",
                            destination: AnyView(BillTillPayView())
                        )
                        HomeComponent(
                            imageName: "person.fill",
                            title: "Request Money",
                            subTitle: "Request money from wesaccomobile users",
                            destination: AnyView(BuyAirtimeView())
                        )
                        HomeComponent(
                            imageName: "gearshape.fill",
                            title: "Buy Airtime",
                            subTitle: "Top-up or send airtime across all network",
                            destination: AnyView(SendMoneyView())
                        )
                        HomeComponent(
                            imageName: "gearshape.fill",
                            title: "PayBill",
                            subTitle: "Manage all your bills and merchant transactions",
                            destination: AnyView(BillTillPayView())
                        )
                    }
                }
                .padding(.horizontal)
                
                // Promotions Section
                HStack {
                    Text("Promotions")
                        .font(.headline)
                        .padding(.horizontal)
                    Spacer()
                    Text("Show All")
                        .foregroundColor(.green)
                        .padding(.horizontal)
                }
                .padding(.top)

            }
            .navigationTitle("Homes")
            .navigationBarTitleDisplayMode(.inline)
        }
    
    }
       

}

#Preview {
    HomeComponent(
        imageName: "house.fill",
        title: "Home", 
        subTitle: "Go to your dashboard",
        destination: AnyView(HomeView())
    )
    .previewLayout(.sizeThatFits)
    .padding()

}
