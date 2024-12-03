//
//  TransactView.swift
//  iosApp
//
//  Created by stephen chacha on 23/10/2024.
//

import SwiftUI

struct TransactView: View {
    @State private var selectedCategory = "All" // Default selected tab

    let categories = ["All", "Transact", "Travel & Shop", "Invest & Save"]

    var body: some View {
        NavigationView {
            VStack {
                ScrollView(.horizontal, showsIndicators: false) {
                    HStack(spacing: 20) {
                        ForEach(categories, id: \.self) { category in
                            Button(action: {
                                selectedCategory = category
                            }) {
                                Text(category)
                                    .padding()
                                    .background(selectedCategory == category ? Color.green.opacity(0.1) : Color.clear)
                                    .foregroundColor(selectedCategory == category ? .green : .gray)
                                    .overlay(RoundedRectangle(cornerRadius: 10)
                                    .stroke(selectedCategory == category ? Color.green : Color.gray, lineWidth: selectedCategory == category ? 2 : 1))
                            }
                        }
                    }
                    .padding(.horizontal)
                }

                Text("Here are some things you can do")
                    .font(.headline)
                    .padding(.top, 20)
                    .padding(.leading)

                // Display grid with sections if "All" is selected
                if selectedCategory == "All" {
                    ScrollView {
                        // Loop through categories (except "All")
                        ForEach(categories.filter { $0 != "All" }, id: \.self) { category in
                            let featuresForCategory = allFeatures.filter { $0.category == category }

                            // Only show category if there are features for it
                            if !featuresForCategory.isEmpty {
                                VStack(alignment: .leading) {
                                    // Show title only if there are features
                                    Text(category)
                                        .font(.title2)
                                        .fontWeight(.bold)
                                        .padding(.leading)
                                        .padding(.top, 10)

                                    LazyVGrid(columns: [GridItem(.flexible()), GridItem(.flexible()), GridItem(.flexible())], spacing: 20) {
                                        ForEach(featuresForCategory) { feature in
                                            TransactionButton(title: feature.title, imageName: feature.imageName, destination: feature.destination)
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    let featuresForCategory = filteredFeatures()
    
                    VStack(alignment: .leading){
                        if !featuresForCategory.isEmpty {
                            Text(selectedCategory) // Show title for the selected category
                                .font(.title2)
                                .fontWeight(.bold)
                                .padding(.top, 10)
                            
                            LazyVGrid(columns: [GridItem(.flexible()), GridItem(.flexible()), GridItem(.flexible())], spacing: 20) {
                                ForEach(featuresForCategory) { feature in
                                    TransactionButton(title: feature.title, imageName: feature.imageName, destination: feature.destination)
                                }
                            }
                            .padding(.top)
                        }
                    }
                }

                Spacer()
            }
            .navigationTitle("Transact")
        }
        .padding(.horizontal)
    }

    func filteredFeatures() -> [Feature] {
        if selectedCategory == "All" {
            return allFeatures // Show all features if 'All' is selected
        } else {
            return allFeatures.filter { $0.category == selectedCategory } // Filter by category
        }
    }
}




#Preview {
    TransactView()
}
